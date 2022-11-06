package com.socket.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    int id;
    String name;
    String password;
    List<ChatMessage> chatMessages;
    List<String> users; // Yeah I know, will change String to something else in future!

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
