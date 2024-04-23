package com.group4.vms.webserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteDashboardController {

    @GetMapping("/volunteerdashboard")
    String getDashboardPage(){
        return "volunteerdashboard";
    }
    @GetMapping("/admindashboard")
    String getAdminDashboardPage(){
        return "admindashboard";
    }

}
