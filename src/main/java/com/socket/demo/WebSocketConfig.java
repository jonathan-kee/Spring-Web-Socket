package com.socket.demo;

import com.socket.demo.auth.RandomUsernameHandshakeHandler;
import com.socket.demo.auth.UserHandshakeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final RandomUsernameHandshakeHandler randomUsernameHandshakeHandler;

    public WebSocketConfig(RandomUsernameHandshakeHandler randomUsernameHandshakeHandler) {
        this.randomUsernameHandshakeHandler = randomUsernameHandshakeHandler;
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp-endpoint")
                // https://www.youtube.com/watch?v=LdQY-OUM2mk&ab_channel=LiliumCode
                //.setHandshakeHandler(new UserHandshakeHandler())
                .setHandshakeHandler(randomUsernameHandshakeHandler)
                // ^ This wierd handmade UserHandshakeHandler can be fixed by Spring Security I think
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Any destination that starts with /app is forward to controllers
        registry.setApplicationDestinationPrefixes("/app");

        // I think this works as above too
        // https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/websocket.html#websocket-stomp-user-destination
        // NOT NEEDED, this method just overrides the default which is already "/user"
        registry.setUserDestinationPrefix("/user");

        // Built-in broker, everything in memory
        // /topic is known as destination
        registry.enableSimpleBroker("/topic","/subject", "/queue");
    }
}


