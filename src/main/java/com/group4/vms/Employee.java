package com.group4.vms;

import org.bson.types.ObjectId;

public class Employee extends User {

    private boolean adminPrivs;

    public Employee(ObjectId id, String name, String pronouns, ObjectId[] events) {
        super(id, name, pronouns, true, events);
    }

    public void setAdminPrivs() {
        // should only be used to revoke admin privs from this Employee
        this.adminPrivs = false;
    }
}
