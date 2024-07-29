package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "chat_topic"; // Kafka topic

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
    }
}