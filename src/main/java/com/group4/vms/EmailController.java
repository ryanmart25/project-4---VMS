package com.group4.vms;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class EmailController {
    @GetMapping
    public List<Message> getAllMessagesByUserID(){

    }
    @PostMapping("/api/v1/postmessage{sender}{receipient}")
    public boolean postMessage(){

    }
}
