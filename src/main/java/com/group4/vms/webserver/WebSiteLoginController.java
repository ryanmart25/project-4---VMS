package com.group4.vms.webserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSiteLoginController {
    @GetMapping("/")
    String getLoginPage(){
        return "login";
    }
    @GetMapping("/createaccount")
    String getCreateAccountPage(){
        return "createaccount";
    }
}
