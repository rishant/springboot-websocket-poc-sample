package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	public static final String STOM_SOCKET_CONNECTION_ENDPOINT = "/stomp-endpoint";
	public static final String STOM_SOCKET_RC_SOCKET_URL = "rc-notification-socket";
	public static final String STOM_TPOIC_RC_NOTIFICATION = "/rc-notification";
	public static final String STOM_API_ENDPOINT_PREFIX = "/app";
	public static final String STOM_TPOIC = "/topic";

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker(STOM_TPOIC, STOM_TPOIC_RC_NOTIFICATION);
		registry.setApplicationDestinationPrefixes(STOM_API_ENDPOINT_PREFIX);
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
         registry.addEndpoint(STOM_SOCKET_CONNECTION_ENDPOINT,STOM_SOCKET_RC_SOCKET_URL).withSockJS();
	}
}
