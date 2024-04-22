package com.group4.vms.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
public class User{

    @Id
    private ObjectId id;
    private String name, email, password, pronouns;
    private boolean approved;

    public User(ObjectId id, String name, String email, String password, String pronouns, boolean approved) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.pronouns = pronouns;
        this.approved = approved;
    }
}

