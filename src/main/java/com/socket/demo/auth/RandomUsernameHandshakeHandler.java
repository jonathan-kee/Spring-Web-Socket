package com.socket.demo.auth;

import com.sun.security.auth.UserPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.Random;

enum Adjectives {
    ADORABLE,
    ADVENTUROUS,
    AGGRESSIVE,
    BRAVE,
    BORED,
    BRAINY
}

enum Nouns {
    MILK,
    BREAD,
    BUTTER,
    CHEESE,
    YOGURT,
    SANDWICH
}

class UsernameGenerator{
    private Adjectives[] adjectives = Adjectives.values();
    private Adjectives adjective = adjectives[new Random().nextInt(adjectives.length)];

    private Nouns[] nouns = Nouns.values();
    private Nouns noun = nouns[new Random().nextInt(nouns.length)];

    private Adjectives getAdjective() {
        return adjective;
    }

    private Nouns getNoun() {
        return noun;
    }

    public String generate(){
        return getAdjective()+"-"+ getNoun();
    }
}

public class RandomUsernameHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String userName = new UsernameGenerator().generate();
        return new UserPrincipal(userName);
    }
}
