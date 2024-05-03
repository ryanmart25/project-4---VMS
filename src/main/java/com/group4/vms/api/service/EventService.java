package com.group4.vms.api.service;

import com.group4.vms.api.model.Event;
import com.group4.vms.api.repository.EventRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService { //TODO Revert, Implement lookup using simple FindAll or findbyID

    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;

    }

    public List<Event> getByUserID(ObjectId userid){ //return events the user is signed up for.
        //return array[List<Event>] array[0] list of events this user is signed up for
        //list they are not signed up for.
        return eventRepository.getMyEvents(userid);

    }

    public List<Event> getOtherEvents(ObjectId volunteerID){ //grab all events the volunteer is NOT signed up for
        return eventRepository.getOtherEvents(volunteerID);

    }

    public List<Event> getEventList(){
        return this.eventRepository.getAllEvents();

    }

}
