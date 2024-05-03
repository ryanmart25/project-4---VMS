package com.group4.vms.api.service;

import com.group4.vms.api.model.Event;
import com.group4.vms.api.repository.EventRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EventService { //TODO Revert, Implement lookup using simple FindAll or findbyID

    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;

    }

    public Event getEventInfo(ObjectId id){
        return eventRepository.getEventInfo(id);
    }

    public List<Event> getByUserID(ObjectId userid){ //return events the user is signed up for.
        return eventRepository.getMyEvents(userid);

    }

    public List<Event> getOtherEvents(ObjectId volunteerID){ //grab all events the volunteer is NOT signed up for
        return eventRepository.getOtherEvents(volunteerID);

    }

    public List<Event> getEventList(){
        return this.eventRepository.getAllEvents();

    }

    public Event editEventName(ObjectId eventid, String newName){
        return this.eventRepository.editEventName(eventid, newName);

    }

    public Event editEventDescription(ObjectId eventid, String newDesc){
        return this.eventRepository.editEventDescription(eventid, newDesc);

    }

    public Event editEventStart(ObjectId eventid, String newStart){
        return this.eventRepository.editEventStart(eventid, newStart);

    }

    public Event editEventEnd(ObjectId eventid, String newEnd){
        return this.eventRepository.editEventEnd(eventid, newEnd);

    }

    public Event editEventLen(ObjectId eventid, Double newLen){
        return this.eventRepository.editEventLen(eventid, newLen);

    }

    public Event editEventDate(ObjectId eventid, Date newDate){
        return this.eventRepository.editEventDate(eventid, newDate);

    }

    public Event editEventManager(ObjectId eventid, String newManager){
        return this.eventRepository.editEventManager(eventid, newManager);

    }

    public Event editEventLocation(ObjectId eventid, String newLocation){
        return this.eventRepository.editEventLocation(eventid, newLocation);

    }

    public Event removeVolunteer(ObjectId eventid, ObjectId volunteerid){
        return this.eventRepository.removeVol(eventid, volunteerid);

    }
    
    public Event denyVolunteer(ObjectId eventid, ObjectId volunteerid){
        return this.eventRepository.denyVol(eventid, volunteerid);

    }
    
    public Event acceptVolunteer(ObjectId eventid, ObjectId volunteerid){
        return this.eventRepository.acceptVol(eventid, volunteerid);

    }
    
    public Event removeEvent(ObjectId eventid){
        return this.eventRepository.removeEvent(eventid);

    }
    
    public Event newEvent(String title, String start, String end, Double duration, Date date, String manager, String location, String description){
        Event e = new Event(new ObjectId(), title, start, end, duration, date, manager, location, description, new ObjectId[0], new ObjectId[0]);
        return this.eventRepository.addEvent(e);

    }
    

    

}
