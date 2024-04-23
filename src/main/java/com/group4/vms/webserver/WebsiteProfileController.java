package com.group4.vms.webserver;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteProfileController {

    @GetMapping("/volunteerProfile")
    String getVolunteerProfilePage(){
        return "volunteerprofile";
    }
    @GetMapping("/adminProfile")
    String getAdminProfilePage(){
        return "adminprofile";
    }
}
