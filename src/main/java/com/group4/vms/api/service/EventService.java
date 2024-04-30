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

    public List<Event> getbyUserID(ObjectId userid){ //return events the user is signed up for.
        return eventRepository.getMyEvents(userid);

    }
    
    public List<Event> getOtherEvents(ObjectId volunteerID){ //grab all events the volunteer is NOT signed up for
        return eventRepository.getOtherEvents(volunteerID);

    }

    public List<Event> getByUserName(String firstname, String lastname){ //TODO refactor, only query the Volunteer field.
        return eventRepository.getMyEvents(firstname, lastname);

    }

    public List<Event> getEventList(){
        return this.eventRepository.getAllEvents();

    }

}
