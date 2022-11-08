package com.socket.demo.auth;

import com.sun.security.auth.UserPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
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
    private final Nouns noun = Nouns.values()[new Random().nextInt(Nouns.values().length)];
    private final Adjectives adjective = Adjectives.values()[new Random().nextInt(Adjectives.values().length)];

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

@Component
public class RandomUsernameHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String userName = new UsernameGenerator().generate();
        return new UserPrincipal(userName);
    }
}
