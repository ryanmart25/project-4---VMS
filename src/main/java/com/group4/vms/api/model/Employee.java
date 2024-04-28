package com.group4.vms.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee extends User{

    //private boolean adminPrivs;

    public Employee(ObjectId id, String name, String email, String password, String pronouns, boolean isEmployee, boolean approved) {
        super(id, name, email, password, pronouns, isEmployee, approved);
        //this.adminPrivs = true;
    }


    public void setAdminPrivs() {
        // should only be used to revoke admin privs from this Employee
        //this.adminPrivs = !this.adminPrivs;
        this.setIsEmployee(!getIsEmployee());
    }
}
