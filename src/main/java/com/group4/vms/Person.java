package com.group4.vms;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {
    @Id
    private ObjectId id;
    private String Name;
    private String pronouns;
}
