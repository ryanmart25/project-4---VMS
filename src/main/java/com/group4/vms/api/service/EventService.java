package com.group4.vms.api.service;

import com.group4.vms.api.model.Event;
import com.group4.vms.api.repository.EventRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService { //TODO Revert, Implement lookup using simple FindAll or findbyID

    //private final MongoTemplate mongoTemplate; //template
    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
        //this.mongoTemplate = template;
    }
    public List<Event> getbyUserID(ObjectId userid){ //return events the user is signed up for.
        //Search through Events.volunteers for userID.

        //return this.eventRepository. //TODO have to make a filter, supply it to the eventrepository method
        //List<Event list = this.eventRepository.findAll(Example.of(Event.class));
        return null;
    }
    public List<Event> getOtherEvents(ObjectId volunteerID){ //grab all events the volunteer is NOT signed up for

        //List<Event> list = this.mongoTemplate.query(Event.class)
        //        .matching(query(where("_id").not().is(volunteerID))).all();
        return null;
    }
    public List<Event> getByUserName(String firstname, String lastname){ //TODO refactor, only query the Volunteer field.
        //Search for a volunteer with firstname and lastname.
        //Have to Walk through an array,
        //Build up Probe for Example
        return null;
    }
    private List<Event> getEventsHelper(ObjectId id){ //helper
        return null;
    }
}
