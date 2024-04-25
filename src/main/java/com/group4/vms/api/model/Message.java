package com.group4.vms.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Message {
    @Id
    private String id;
    private String sender; 
    private String recipient; 
    private String body;

   
}
