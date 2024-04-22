package com.group4.vms.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "volunteers")
public class Volunteer extends User{
        
    public Volunteer(ObjectId id, String name, String email, String password, String pronouns) {
        super(id, name, email, password, pronouns, false);
    }

    public Volunteer() {
        super();
    }
}

