package com.group4.vms.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "timesheet")
public class Entry {
    @Id
    ObjectId id;
    private String name;
    private ObjectId[] events;
    private double[] timeVolunteered;
}
