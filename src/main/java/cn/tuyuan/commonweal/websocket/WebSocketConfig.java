package cn.tuyuan.commonweal.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
      try {
    	  registry.addHandler(webSocketHandler(),"/websocket/socketServer.do").setAllowedOrigins("*")
          .addInterceptors(getHandlerInterceptor());
          registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do")
          .setAllowedOrigins("*").addInterceptors(getHandlerInterceptor()).withSockJS();
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
 
    @Bean
    public TextWebSocketHandler webSocketHandler(){
        return new SpringWebSocketHandler();
    }
    
    @Bean
    public HttpSessionHandshakeInterceptor getHandlerInterceptor(){
        return new SpringWebSocketHandlerInterceptor();
    }

}