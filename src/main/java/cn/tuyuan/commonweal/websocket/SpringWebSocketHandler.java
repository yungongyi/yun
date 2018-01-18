package cn.tuyuan.commonweal.websocket;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import cn.tuyuan.commonweal.check.CheckSend;

import com.alibaba.fastjson.JSON;

/*
 * 消息处理器
 */
public class SpringWebSocketHandler extends TextWebSocketHandler {
	
	private static final ArrayList<WebSocketSession> users;//这个会出现性能问题，最好用Map来存储，key用userid
	
	private static Logger logger = Logger.getLogger(SpringWebSocketHandler.class);
	
	static {
		users = new ArrayList<WebSocketSession>();
	}

	public SpringWebSocketHandler() {}

	/**
	 * 连接成功时候，会触发页面上onopen方法
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {	
		/*连接成功*/
		System.out.println("1."+session.getAttributes().get("WEBSOCKET_USERNAME")+"登陆成功，来自WebSocketSession");
		users.add(session);	
		System.out.println("2.connect to the websocket success......当前在线数量:"+users.size());
		//这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
		if(session.getAttributes().get("WEBSOCKET_USERNAME").toString().indexOf("a_")==0){
			TextMessage returnMessage = new TextMessage("3.欢迎进入云公益系列网站;您尚未登录");
			session.sendMessage(returnMessage);
		};
	}
	/**
	 * 关闭连接时触发
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		String username= (String) session.getAttributes().get("WEBSOCKET_USERNAME");
		System.out.println("用户"+username+"已退出！");
		users.remove(session);
		System.out.println("剩余在线用户"+users.size());
	}

	/**
	 * js调用websocket.send时候，会调用该方法
	 */
	@Override    
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String username= (String) session.getAttributes().get("WEBSOCKET_USERNAME");
		
		if(CheckSend.checkSendSize(1,"null")==false){
			sendMessageToUser(username,new TextMessage("今日广播次数已满"));
		}else{
			sendMessageToUsers(new TextMessage(message.getPayload()));
		}
		
		super.handleTextMessage(session, message);
	}

	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if(session.isOpen()){session.close();}
		logger.debug("websocket connection closed......");
		users.remove(session);
	}

	public boolean supportsPartialMessages() {
		return false;
	}


	/**
	 * 给某个用户发送消息
	 *
	 * @param userName
	 * @param message
	 */
	public void sendMessageToUser(String userName, TextMessage message) {
		System.out.println(userName);
		
		for (WebSocketSession user : users) {
			System.out.println(user.getAttributes().get("WEBSOCKET_USERNAME"));
			if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName.toString())) {
				try {
					if (user.isOpen()) {
						System.out.println("发送");
						user.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	/**
	 * 给所有在线用户发送消息
	 *
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
					System.out.println(user.toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
