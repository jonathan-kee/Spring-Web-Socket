package com.socket.demo.controller;

import com.socket.demo.domain.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SimpleController {
    private final SimpMessagingTemplate messageSender;

    // Somehow Spring knows there's a dependency for SimpMessagingTemplate even though I never created code related to it!
    public SimpleController(SimpMessagingTemplate messageSender){
        this.messageSender = messageSender;
    }

    @MessageMapping("chat-room")
    // by default, when you send something from controller,
    // the return be will send to a destination with prefix of /topic & same name as destination, which is chat-room
    // So... @SendTo("/topic/chat-room") is not needed. But I think @SendTo(/topic/chat-room) is good practise

    // subject already set in registry.enableSimpleBroker("/topic","/subject"); But not chat-room-number1
    @SendTo("/subject/chat-room-number1")
    public ChatMessage process(ChatMessage input){
        var upperCaseMessage = input.getMessage().toUpperCase();
        input.setMessage(upperCaseMessage);
        return input;
    }

    @MessageMapping("chat-room2")
    public void process2(ChatMessage input){
        System.out.println("Process 2 called");
        System.out.println(input.getUser());
        System.out.println(input.getMessage());
        var upperCaseMessage = input.getMessage().toUpperCase();
        input.setMessage(upperCaseMessage+"THIS IS WORKING!");
        messageSender.convertAndSend("/subject/chat-room-number"+rngNumber(), input );
    }

    private int rngNumber(){
        return 2;
    }
}
