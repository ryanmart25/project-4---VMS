package com.group4.vms.api.service;

import com.group4.vms.api.model.Employee;
import com.group4.vms.api.model.Entry;
import com.group4.vms.api.repository.TimesheetRepository;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimesheetService {

    @Autowired
    private TimesheetRepository timesheetRepository;

    public List<Entry> getAllEntries() {
        return timesheetRepository.getAllEntries();
    }

    public HttpStatus postEntries(List<Entry> entries) {
        return HttpStatus.NOT_IMPLEMENTED;
    }
    public HttpStatus postEntry(Entry entry){
        return HttpStatus.NOT_IMPLEMENTED;
    }
    public HttpStatus patchEntries(List<Entry> entries){
        return HttpStatus.NOT_IMPLEMENTED;
    }

    public Employee saveEntry(Entry entry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveEntry'");
    }
}
