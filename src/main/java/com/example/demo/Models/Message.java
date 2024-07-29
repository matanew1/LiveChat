package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_message") // Specifies the table name
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Specifies the column name
    private Long id;

    @Column(name = "content", length = 255, nullable = false) // Specifies column name, length, and nullability
    private String content;

    @Column(name = "sender", length = 255, nullable = false) // Specifies column name, length, and nullability
    private String sender;

    // Constructors
    public Message() {}
    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
