package com.group4.vms.api.controller;

import com.group4.vms.api.service.ApprovalService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApprovalController {
    @Autowired
    ApprovalService approvalService;

    @GetMapping("api/v1/approval")
    public boolean getApproval(
            @RequestParam(value="name", required = false) String name,
            @RequestParam(value ="email") String email,
            @RequestParam(required = false, value = "id") ObjectId id)
    {
        if(id!=null && name!=null){
            return this.approvalService.getApprovalStatus(name, email,id);
        }
        else{
            return this.approvalService.getApprovalStatus(email);
        }
    }

}
