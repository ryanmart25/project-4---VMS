package com.group4.vms.api.service;

import com.group4.vms.api.controller.ApprovalController;
import com.group4.vms.api.model.Employee;
import com.group4.vms.api.model.Volunteer;
import com.group4.vms.api.repository.EmployeeRepository;
import com.group4.vms.api.repository.VolunteerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService {
    @Autowired
    private final VolunteerRepository volunteerRepository;
    @Autowired
 private final EmployeeRepository employeeRepository;

    public ApprovalService(VolunteerRepository volunteerRepository, EmployeeRepository employeeRepository) {
        this.volunteerRepository = volunteerRepository;
        this.employeeRepository = employeeRepository;
    }


    public boolean getApprovalStatus(String email){
        List<Employee> employees = this.employeeRepository.getLoginInfo(email);
        List<Volunteer> volunteers = this.volunteerRepository.getLoginInfo(email);
        if(employees.isEmpty() && volunteers.isEmpty()){
            return false;
        }
        if(volunteers.isEmpty()){
            for (Employee employee : employees) {
                if(employee.isApproved()){
                    return true;
                }
            }
        }
        else{
            for (Volunteer vol :
                    volunteers) {
                if(vol.isApproved()){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean getApprovalStatus(String name, String email, ObjectId id){
        Employee emp = this.employeeRepository.getApprovalStatus(name, email, id);
        Volunteer vol = this.volunteerRepository.getApprovalStatus(name, email, id);
        if(emp== null && vol==null){
            return false;
        }
        if(vol==null){
            if(emp.isApproved())
                return true;
        }
        assert vol != null;
        return vol.isApproved();
    }
}
