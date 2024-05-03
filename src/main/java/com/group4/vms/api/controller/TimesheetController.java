package com.group4.vms.api.controller;

import com.group4.vms.api.model.Employee;
import com.group4.vms.api.model.Entry;
import com.group4.vms.api.service.TimesheetService;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimesheetController {

    //fields
    @Autowired
    private TimesheetService timesheetService;

    //methods
    @GetMapping("/api/v1/timesheet/getAllEntries")
    public ResponseEntity<List<Entry>> getAllEntries(){
        List<Entry> entries = this.timesheetService.getAllEntries();
        return ResponseEntity.ok(this.timesheetService.getAllEntries());
    }
    @PostMapping("/api/v1/timesheet/postEntries")
    public  ResponseEntity<Employee> postEntries(@RequestBody Entry entry){
        Employee savedEmployee = this.timesheetService.saveEntry(entry);
        if (savedEmployee != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
