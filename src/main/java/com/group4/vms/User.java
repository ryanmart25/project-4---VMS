package com.group4.vms;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String pronouns;
    private boolean adminPrivs;
    private ObjectId[] events;  // use a stack/queue instead for fast insertion/deletion?
                                // yes, TODO change from array to stack;
}
