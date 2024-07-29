package com.example.demo.Controllers;

import com.example.demo.Models.Message;
import com.example.demo.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        chatService.sendMessage(message); // Send message to Kafka
        return message;
    }
}