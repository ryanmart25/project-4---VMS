package com.group4.vms;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmailController {
    @GetMapping
    public List<Message> getAllMessagesByUserID(){
    return null;
    }
    @PostMapping("/api/v1/postmessage{sender}{receipient}")
    public boolean postMessage(){
        return false;
    }
}
