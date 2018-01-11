package cn.tuyuan.commonweal.websocket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * WebSocket拦截�?
 * @author WANG
 *
 */
public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {

	 @Override
	    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
	            Map<String, Object> attributes) throws Exception {
	        // TODO Auto-generated method stub
	        System.out.println("Before Handshake");
	        if (request instanceof ServletServerHttpRequest) {
	            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
	            HttpSession session = servletRequest.getServletRequest().getSession(false);
	           
	            if (session != null) {
	                //使用userName区分WebSocketHandler，以便定向发送消息
	            	String userName = (String) session.getAttribute("SESSION_USERNAME");
	                System.out.println(userName+"普通到达拦截器");
		            attributes.put("WEBSOCKET_USERNAME",userName);
	            }else{
	            	String userName =RandomName.getStringRandom(8);
	                System.out.println(userName+"随机用户生成");
		            attributes.put("WEBSOCKET_USERNAME",userName);
	            }
	              
	            
	        }
	        return super.beforeHandshake(request, response, wsHandler, attributes);
	        
	    }
	    
	    @Override
	    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
	            Exception ex) {
	        // TODO Auto-generated method stub
	        super.afterHandshake(request, response, wsHandler, ex);
	    }
	
}