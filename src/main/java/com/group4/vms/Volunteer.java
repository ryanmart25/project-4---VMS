package com.group4.vms;

import javax.print.attribute.standard.MediaSize.NA;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.sym.Name;

public class Volunteer extends Person {
    // An array of events this Volunteer is signed up for?
    private ObjectId[] events; // use a stack/queue instead for fast insertion/deletion?
                               // yes, TODO change from array to stack;

    public Volunteer(ObjectId id, String name, String pronouns) {
        super(id, name, pronouns);
    }

    private String addEvent(ObjectId id) { // Error, do not use until stack is implemented.
        for (ObjectId objectId : events) {
            if (objectId.equals(id)) {
                return "event already exists";
            }
        }

    }
}
