package com.group4.vms;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    ObjectId id;
    Date date;
    TimeDuration duration;
    private LinkedList volunteerList;
}
