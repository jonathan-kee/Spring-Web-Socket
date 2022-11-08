package com.socket.demo.controller;

import com.socket.demo.domain.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

// https://www.baeldung.com/spring-websockets-send-message-to-user

// https://stackoverflow.com/questions/30898449/how-do-i-send-a-message-in-an-spring-applicationlistener-sessionconnectedevent
// Need to annotate for Spring it to work
@Controller
public class Connect implements ApplicationListener<SessionSubscribeEvent> {
    private final SimpMessagingTemplate messageSender;
    private final ChatRoom chatRoom;

    // Somehow Spring knows there's a dependency for SimpMessagingTemplate even though I never created code related to it!
    public Connect(SimpMessagingTemplate messageSender){
        this.messageSender = messageSender;
        this.chatRoom = new ChatRoom(1,"nicompoop!");
    }

    @Override
    public void onApplicationEvent(SessionSubscribeEvent event) {
        String correctDestination = (String) event.getMessage().getHeaders().get("simpDestination");
        if(correctDestination.equals("/user/queue/storedMessages")){
            System.out.println("Connected");
            // This was possible because of
            // .setHandshakeHandler(new UserHandshakeHandler()) in WebSocketConfig.java
            String id = event.getUser().getName();
            System.out.println(id);
            for(var chatMessage : this.chatRoom.getChatMessages()){
                System.out.println(chatMessage);
                //messageSender.convertAndSend("/subject/chat-room-number2", chatMessage );
                messageSender.convertAndSendToUser(id,"/queue/storedMessages", chatMessage);
            }
        }
    }
}
