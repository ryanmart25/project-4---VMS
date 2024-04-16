package com.group4.vms.api.config.controller;

import com.group4.vms.api.config.utility.Message;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmailController {
    @GetMapping("/api/v1/messages")
    public List<Message> getAllMessagesByUserID(){
    return null;
    }
    @PostMapping("/api/v1/postmessage{sender}{receipient}")
    public boolean postMessage(){
        return false;
    }
}
