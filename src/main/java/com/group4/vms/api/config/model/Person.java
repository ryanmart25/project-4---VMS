package com.group4.vms.api.config.model;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private ObjectId id;
    private String Name;
    private String pronouns;
}
