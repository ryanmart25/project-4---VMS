package com.group4.vms.api.config.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee extends Person {

    private boolean adminPrivs;

    public Employee(ObjectId id, String name, String pronouns) {
        super(id, name, pronouns);
        this.adminPrivs = true;
    }

    public Employee() {
        super();
    }

    public void setAdminPrivs() {
        // should only be used to revoke admin privs from this Employee
        this.adminPrivs = false;
    }
}
