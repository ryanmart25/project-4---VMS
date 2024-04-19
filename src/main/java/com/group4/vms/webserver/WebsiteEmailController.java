package com.group4.vms.webserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WebsiteEmailController {
    @GetMapping("/email")
    public String getEmailWebpage(){
        return "email";
    }
}
