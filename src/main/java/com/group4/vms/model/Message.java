package com.group4.vms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String body;
    private String recipient;
    private String sender;
    private String time;

   
}
