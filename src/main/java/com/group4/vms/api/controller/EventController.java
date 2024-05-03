package com.group4.vms.api.controller;

import com.group4.vms.api.model.Event;
import com.group4.vms.api.service.EventService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService = eventService;
    }
    @GetMapping("api/v1/allEvents")//get every single event
    public List<Event> getAllEvents(){
        return eventService.getEventList();
    }
    @GetMapping("/api/v1/otherEvents{userID}")
    public List<Event> getOtherEvents(@RequestParam(value = "userid", defaultValue = "0000000") ObjectId id){
        return this.eventService.getOtherEvents(id);
    }
    @GetMapping("/api/allEvents{userid}") //Get all Events This user is signed up for //
    public List<Event> getUsersEvents(
            @RequestParam(value = "userid", defaultValue = "00000000") String userid
            ) {

        return eventService.getByUserID(new ObjectId(userid));
    }

}
