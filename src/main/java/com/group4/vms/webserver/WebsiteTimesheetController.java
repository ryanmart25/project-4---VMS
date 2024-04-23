package com.group4.vms.webserver;

import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteTimesheetController {
    @GetMapping("/timesheet")
    String getTimesheetPage(){
        return "timesheet";
    }
}
