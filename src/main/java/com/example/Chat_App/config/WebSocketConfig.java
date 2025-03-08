package com.example.Chat_App.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")       // adding the endpoint for websocket connection (localhost:8080/chat)
                .setAllowedOrigins("http://localhost:8080")         // we want to receive requests from this url only
                .withSockJS();                  // browser that not supports websocket it will help in compatibility.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //set message brocker
        // so let say we have /topic/chatroom1 who ever is in this chatroom and sending message here and whoever is subscribed
        // all will get the message. So this is a channel we are creating here.
        registry.enableSimpleBroker("/topic");

        // expect message with /app/sendMessage  --> defined in controller
        // here we are telling the server that any message you get with this prefix process it
        registry.setApplicationDestinationPrefixes("/app");

    }
}


// Message broking is a concept or a way of routing messages