package com.socket.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private final int id;
    private final String name;
    private String password;
    private final List<ChatMessage> chatMessages;
    private List<String> users; // Yeah I know, will change String to something else in future!

    public ChatRoom(int id, String name) {
        chatMessages = new ArrayList<>();
        chatMessages.add(new ChatMessage("test1","hello1"));
        chatMessages.add(new ChatMessage("test2","Ola2"));
        chatMessages.add(new ChatMessage("test3","Ni hao3"));
        this.id = id;
        this.name = name;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }
}
