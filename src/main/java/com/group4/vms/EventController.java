package com.group4.vms;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/allEvents")//get every single event
    public List<Event> getAllEvents(){
        return this.eventService.findAll();
    }
    @GetMapping("/allEvents{userid}") //Get all Events This user is signed up for // TODO someone else do this.
    public List<Event> getUsersEvents(
            @RequestParam(value = "userid", defaultValue = "00000000") String userid
            )
    {
    return this.eventService;
    }

}
