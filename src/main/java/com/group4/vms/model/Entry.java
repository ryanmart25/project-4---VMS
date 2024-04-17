package com.group4.vms.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.*;

@Data
@Document(collection = "timesheet")
public class Entry {
    @Id
    ObjectId id;
    private String name;
    private ObjectId[] events;
    private double[] timeVolunteered;
    public List<Double> getTimeVolunteered() {
        List<Double> timeVolunteeredList = new ArrayList<>();
        for (double time : timeVolunteered) {
            timeVolunteeredList.add(time);
        }
        return timeVolunteeredList;
        
    }
}
