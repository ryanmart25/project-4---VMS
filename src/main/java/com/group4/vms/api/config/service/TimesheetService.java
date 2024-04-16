package com.group4.vms.api.config.service;

import com.group4.vms.api.config.model.Entry;
import com.group4.vms.api.config.repository.TimesheetRepository;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    public List<Entry> getAllEntries() {
        return timesheetRepository.getAllEntries();
    }

    public HttpStatus postEntries(JsonObject requestBody) {
        return HttpStatus.NOT_IMPLEMENTED;
    }
    public HttpStatus postEntry(JsonObject requestBody){
        return HttpStatus.NOT_IMPLEMENTED;
    }
    public HttpStatus patchEntries(JsonObject requestBody){
        return HttpStatus.NOT_IMPLEMENTED;
    }
}
