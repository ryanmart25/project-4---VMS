package com.group4.vms;

import java.util.Stack;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
public record Volunteer(ObjectId id, String name, String eail, String password, String pronouns, ObjectId[] events) {}
    // An array of events this Volunteer is signed up for?
    //private ObjectId[] events; // use a stack/queue instead for fast insertion/deletion?
                               // yes, TODO change from array to stack;
    





    //private String addEvent(ObjectId id) { // Error, do not use until stack is implemented.
    //    for (ObjectId objectId : events) {
    //        if (objectId.equals(id)) {
    //            return "event already exists";
    //        }
    //    }
    //
    //}

