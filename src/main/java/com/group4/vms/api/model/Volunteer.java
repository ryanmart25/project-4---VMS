package com.group4.vms.api.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "volunteers")
public class Volunteer extends User{
        
    public Volunteer(ObjectId id, String name, String email, String password, String pronouns) {
        super(id, name, email, password, pronouns, false, false);
    }
    public String[] toArray() {
        String[] arr = new String[6];
        arr[0] = this.getName();
        arr[1] = this.getEmail();
        arr[2] = this.getPassword();
        arr[3] = this.getPronouns();
        arr[4] = booleanToString(this.isApproved());
        arr[5] = booleanToString(this.getIsEmployee());
        return arr;
    }
    private static String booleanToString(boolean b){
        if(b){
            return "true";
        }
        else
            return "false";
    }
}

