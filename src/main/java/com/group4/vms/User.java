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

    private String joinEvent(ObjectId eventId) { // Error, do not use until stack is implemented.
        //if (/*is managing event*/); return "cannot join";
        for (ObjectId objectId : events) {
            if (objectId.equals(eventId)) {
                return "event already exists";
            }
        }
        //send join request to event manager?
        return "request sent";
    }
}
