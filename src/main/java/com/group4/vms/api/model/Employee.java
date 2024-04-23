package com.group4.vms.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee extends User{

    private boolean adminPrivs = false;

    public Employee(ObjectId id, String name, String email, String password, String pronouns, boolean approved) {
        super(id, name, email, password, pronouns, approved);

    }


    public void setAdminPrivs() {
        // should only be used to revoke admin privs from this Employee
        this.adminPrivs = !this.adminPrivs;
    }
}
