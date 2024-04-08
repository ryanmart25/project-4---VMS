package com.group4.vms;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

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
