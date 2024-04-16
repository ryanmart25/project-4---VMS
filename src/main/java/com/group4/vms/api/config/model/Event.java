package com.group4.vms.api.config.model;

import java.util.Date;
import java.util.LinkedList;

import com.group4.vms.api.config.utility.TimeDuration;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

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
}
