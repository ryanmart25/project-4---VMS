package com.group4.vms.api.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
public class Event {
    @Id
    ObjectId id;
    String name;
    String start_time;
    String end_time;
    Double duration;
    Date date;
    String manager_name;
    String location;
    String description;
    @DocumentReference
    private ObjectId[] confirmedVolunteer;
    private ObjectId[] requestedVolunteers;
}
