package com.group4.vms.api.model;

import java.util.Date;
import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.group4.vms.api.utility.TimeDuration;

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
    Date date;
    TimeDuration duration;
    @DocumentReference
    private LinkedList<ObjectId> volunteerList;
    private LinkedList<ObjectId> requestedVolunteers;
}
