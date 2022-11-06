package com.socket.demo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage {

    private String user; // will throw null pointer exception if html object variable name is not same
    private String message; // will throw null pointer exception if html object variable name is not same
    private Date sent;

    // This constructor always gets called for @MessageMapping, but Spring automatically set user and message, weird!
    public ChatMessage() {
        System.out.println("No arg constructor called");
        this.sent = new Date();
    }

    public ChatMessage(String message) {
        this("anonymous", message);
        System.out.println("Second constructor called");
    }

    public ChatMessage(String user, String message) {
        System.out.println("Third constructor called");
        this.user = user;
        this.message = message;
        this.sent = new Date();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    @Override
    public String toString() {
        return "ChatMessage [user=" + user + ", message=" + message + ", sent="
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sent) + "]";
    }

}