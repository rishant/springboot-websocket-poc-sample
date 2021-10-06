package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	public static final String STOM_CONNECTION_URL = "/stomp-endpoint";
	public static final String STOM_RC_SOCKET_URL = "rc-notification-socket";
	public static final String RC_NOTIFICATION_TOPIC = "/rc-notification";
	public static final String STOM_API_ENDPOINT_PREFIX = "/app";
	public static final String TOPIC = "/topic";

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker(TOPIC, RC_NOTIFICATION_TOPIC);
		registry.setApplicationDestinationPrefixes(STOM_API_ENDPOINT_PREFIX);
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
         registry.addEndpoint(STOM_CONNECTION_URL,STOM_RC_SOCKET_URL).withSockJS();
	}
}
