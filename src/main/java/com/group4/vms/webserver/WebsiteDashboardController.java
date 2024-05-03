package com.group4.vms.webserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteDashboardController {

    @GetMapping("/VolunteerDashboard")
    String getDashboardPage(){
        return "VolunteerDashboard";
    }
    @GetMapping("/AdminDashboard")
    String getAdminDashboardPage(){
        return "AdminDashboard";
    }

}
