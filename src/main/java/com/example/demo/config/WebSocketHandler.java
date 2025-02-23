package com.example.demo.config;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class WebSocketHandler extends TextWebSocketHandler {
    private static final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private String documentContent = "";
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        session.setTextMessageSizeLimit(1024*1024);
        session.setBinaryMessageSizeLimit(1024*1024);
        sessions.add(session);
        System.out.println("New user connected : "+ session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("Inside");
        documentContent = message.getPayload();
        System.out.println("Received update: " + documentContent);
        for (WebSocketSession session1 : sessions) {
            if (session1.isOpen()) {
                try {
                    session1.sendMessage(new TextMessage(documentContent));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    @Override
    public void afterConnectionClosed (WebSocketSession session, CloseStatus status) {
        System.out.println("Reason - "+status);
        sessions.remove(session);
    }
}
