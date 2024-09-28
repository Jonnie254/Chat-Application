package com.jonnie.websocket_demo.controller;

import com.jonnie.websocket_demo.POJO.Message;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketContoller {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketContoller(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void handleMessage(Message message){
        System.out.println("Received message from user: " + message.getUser() + ": " + message.getMessage());
        simpMessagingTemplate.convertAndSend("/topic/messages", message);
        System.out.println("Sent message to /topic/messages" +message.getUser() + ": " + message.getMessage());
    }
}
