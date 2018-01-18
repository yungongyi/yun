package cn.tuyuan.commonweal.websocket;

import java.util.Map;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import cn.tuyuan.commonweal.util.HttpSessionManager;

/**
 * WebSocket拦截�?
 * @author WANG
 *
 */
public class SpringWebSocketHandlerInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {

		System.out.println("1.进入websocket拦截器");
		if (request instanceof ServletServerHttpRequest) {
			//判断httpsession是否有用户
			String userName =HttpSessionManager.getCurrentIphone();;
			if (userName == null) {			
				userName =RandomName.getStringRandom(8);
				System.out.println("2.拦截器未从httpSession中检索到用户，生成随机用户"+userName);					
			}
			System.out.println(userName);
			attributes.put("WEBSOCKET_USERNAME",userName);
		}
			return super.beforeHandshake(request, response, wsHandler, attributes);
		}

		@Override
		public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
				Exception ex) {
			System.out.println(wsHandler.toString());
			super.afterHandshake(request, response, wsHandler, ex);
		}

	}