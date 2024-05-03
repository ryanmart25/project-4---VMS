package com.group4.vms.api.repository;

import com.group4.vms.api.model.Event;

import java.sql.Date;
import java.util.List;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    public Event getEventInfo(ObjectId id){
        return this.mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Event.class);

    }

    public List<Event> getAllEvents() {
        return this.mongoTemplate.findAll(Event.class, "events");

    }

    public List<Event> getMyEvents(ObjectId userId) {
        return this.mongoTemplate.find(Query.query(Criteria.where("confirmedVolunteers").in(userId)), Event.class, "events");
    }

    public List<Event> getOtherEvents(ObjectId userId) {
        return this.mongoTemplate.find(Query.query(Criteria.where("confirmedVolunteers").in(userId)), Event.class, "events");
    }

    public Event editEventName(ObjectId eventid, String newName){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("name", newName);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }
    }

    public Event editEventDescription(ObjectId eventid, String newDesc){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("description", newDesc);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }
    }

    public Event editEventStart(ObjectId eventid, String newTime){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("start_time", newTime);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }
    }

    public Event editEventEnd(ObjectId eventid, String newTime){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("end_time", newTime);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }
    }

    public Event editEventLen(ObjectId eventid, Double newLen){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("duration", newLen);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }

    }

    public Event editEventDate(ObjectId eventid, Date newDate){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("date", newDate);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }
    }

    public Event editEventManager(ObjectId eventid, String newManager){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("manager_name", newManager);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }
    }

    public Event editEventLocation(ObjectId eventid, String newLocation){
        Query existQuery = new Query();
        existQuery.addCriteria(Criteria.where("_id").is(eventid));

        Update eventUpdate = new Update().set("", newLocation);

        if(!this.mongoTemplate.exists(existQuery, Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        else {
            return this.mongoTemplate.findAndModify(existQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        }
    }

    public Event removeVol(ObjectId eventid, ObjectId volunteerid){
        Query volQuery = new Query();
        volQuery.addCriteria(Criteria.where("_id").is(eventid).and("confirmedVolunteers").in(volunteerid));

        Update eventUpdate = new Update().pull("confirmedVolunteers", volunteerid);

        Event err = new Event();

        if(this.mongoTemplate.findOne(volQuery, Event.class, "events") == null){
            err.setName("Volunteer not found in present Event");
            return err;
        }
        return this.mongoTemplate.findAndModify(volQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        
    }

    public Event denyVol(ObjectId eventid, ObjectId volunteerid){
        Query volQuery = new Query();
        volQuery.addCriteria(Criteria.where("_id").is(eventid).and("requestedVolunteers").in(volunteerid));

        Update eventUpdate = new Update().pull("requestedVolunteers", volunteerid);

        Event err = new Event();

        if(this.mongoTemplate.findOne(volQuery, Event.class, "events") == null){
            err.setName("Volunteer not found in present Event");
            return err;
        }
        return this.mongoTemplate.findAndModify(volQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        
    }

    public Event acceptVol(ObjectId eventid, ObjectId volunteerid){
        Query volQuery = new Query();
        volQuery.addCriteria(Criteria.where("_id").is(eventid).and("requestedVolunteers").in(volunteerid));

        Update eventUpdate = new Update().push("requestedVolunteers", volunteerid);

        Event err = new Event();

        if(this.mongoTemplate.findOne(volQuery, Event.class, "events") == null){
            err.setName("Volunteer not found in present Event");
            return err;
        }
        return this.mongoTemplate.findAndModify(volQuery, eventUpdate, new FindAndModifyOptions().returnNew(true), Event.class, "events");

        
    }

    public Event removeEvent(ObjectId eventid){
        if(!this.mongoTemplate.exists(Query.query(Criteria.where("_id").is(eventid)), Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        return this.mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(eventid)), Event.class, "events");

    }

    public Event addEvent(Event e){
        if(this.mongoTemplate.exists(Query.query(Criteria.where("_id").is(e.getId())), Event.class, "events")){
            Event err = new Event();
            err.setName("No Event Found");
            return err;
        }
        return this.mongoTemplate.insert(e, "events");

    }
}
