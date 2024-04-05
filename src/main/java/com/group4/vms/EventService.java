package com.group4.vms;

import org.bson.types.ObjectId;

import java.util.List;

public class EventService {
    private EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    public List<Event> getbyUserID(ObjectId userid){
        //return this.eventRepository. //TODO have to make a filter, supply it to the eventrepository method
    }

}
