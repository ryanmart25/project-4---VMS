
  package com.group4.vms.api.controller;

import com.group4.vms.api.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.vms.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/api/v1/messages")
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping("/api/v1/messages/send")
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody Message message) {
        // Check if sender is null or empty
        if (message.getSender() == null || message.getSender().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        
        // Check if recipient is null or empty
        if (message.getRecipient() == null || message.getRecipient().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
      
        // Validation successful, proceed to save message
        Message savedMessage = messageService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
    }
    
}


  