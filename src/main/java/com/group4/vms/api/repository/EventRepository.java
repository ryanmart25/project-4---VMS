package com.group4.vms.api.repository;

import com.group4.vms.api.model.Event;

import java.util.List;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Event> getEventInfo(ObjectId id){
        return this.mongoTemplate.find(Query.query(Criteria.where("_id").is(id)), Event.class);

    }

    public List<Event> getAllEvents() {
        return this.mongoTemplate.findAll(Event.class, "events");

    }

    public List<Event> getMyEvents(ObjectId userId) {
        return this.mongoTemplate.find(Query.query(Criteria.where("confirmedVolunteers").elemMatch(Criteria.where("_id").is(userId))), Event.class, "events");
    
    }

    public List<Event> getMyEvents(String fname, String lname) {
        return this.mongoTemplate.find(Query.query(Criteria.where("confirmedVolunteers").elemMatch(Criteria.where("name").is(fname+" "+lname))), Event.class, "events");
    
    }

    public List<Event> getOtherEvents(ObjectId userId) {
        return this.mongoTemplate.find(Query.query(Criteria.where("confirmedVolunteers").elemMatch(Criteria.where("_id").ne(userId))), Event.class, "events");
        //return this.mongoTemplate.find(Query.query(Criteria.where("_id").is(65fdea7cbb89b710efa06419), Event.class, "events"));
    }
}
