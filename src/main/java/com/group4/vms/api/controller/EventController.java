package com.group4.vms.api.controller;

import com.group4.vms.api.model.Event;
import com.group4.vms.api.service.EventService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
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
    public List<Event> getOtherEvents(@RequestParam(value = "userid", defaultValue = "0000000") String userid){
        return this.eventService.getOtherEvents(new ObjectId(userid));
    }
    @GetMapping("/api/allEvents{userid}") //Get all Events This user is signed up for //
    public List<Event> getUsersEvents(@RequestParam(value = "userid", defaultValue = "0000000") String userid){
        
        return this.eventService.getByUserID(new ObjectId(userid));
    }
    @GetMapping("/api/editEvent")
    public Event editEvent(
        @RequestParam(value = "id", required = true) ObjectId id,
        @RequestParam(value = "title", required = false) String title,
        @RequestParam(value = "start", required = false) String start,
        @RequestParam(value = "end", required = false) String end,
        @RequestParam(value = "duration", required = false) Double duration,
        @RequestParam(value = "date", required = false) Date date,
        @RequestParam(value = "manager", required = false) String manager,
        @RequestParam(value = "location", required = false) String location,
        @RequestParam(value = "description", required = false) String description){
            if (title != null){
                this.eventService.editEventName(id, title);
            }
            if (start != null){
                this.eventService.editEventStart(id, start);
            }
            if (end != null){
                this.eventService.editEventEnd(id, end);
            }
            if (duration != null){
                this.eventService.editEventLen(id, duration);
            }
            if (date != null){
                this.eventService.editEventDate(id, date);
            }
            if (manager != null){
                this.eventService.editEventManager(id, manager);
            }
            if (location != null){
                this.eventService.editEventLocation(id, location);
            }
            if (description != null){
                this.eventService.editEventDescription(id, description);
            }
            return this.eventService.getEventInfo(id);
        }

}
