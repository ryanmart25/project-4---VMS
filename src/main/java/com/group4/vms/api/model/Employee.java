package com.group4.vms.api.model;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@Document(collection = "employees")
public class Employee {
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private String pronouns;
    private boolean isEmployee;
    private boolean approved;
    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String[] toArray() {
    String[] arr = new String[6];
    arr[0] = this.getName();
    arr[1] = this.email;
    arr[2] = this.getPassword();
    arr[3] = this.getPronouns();
    arr[4] = booleanToString(this.isApproved());
    arr[5] = booleanToString(this.isEmployee);
    return arr;
    }
    private static String booleanToString(boolean b){
        if(b){
            return "true";
        }
        else
            return "false";
    }

    //private boolean adminPrivs;





}
