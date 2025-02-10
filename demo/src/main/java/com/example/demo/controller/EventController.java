package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.sevice.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController       //the class is for web requests
@RequestMapping("/events")    //mapping to my collection in mongodb
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)        //for posting on web
    public Event createTask(@RequestBody Event event) {        //request body tells spring to transform the http request into an Event object
        return service.addTask(event);

    }

    @GetMapping                 //give the whole collection of events
    public List<Event> getEvents(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Event getTask(@PathVariable String id)       //binds the id from url to the id passed as a parameter
    {
        return service.getEventByEventID(id);
    }

    @GetMapping("/name/{name}")
    public List<Event> findEventUsingName(@PathVariable String name){
        return service.getEventByName(name);
    }

    @GetMapping("/type/{type}")
    public List<Event> findEventUsingType(@PathVariable String type){
        return service.getEventByType(type);
    }

    @PutMapping                 //use put in postman
    public Event modifyEvent(@RequestBody Event event)
    {
        return service.updateEvent(event);
    }

    @DeleteMapping("/{id}")
    public String deleteTasks(@PathVariable String id)
    {
        return service.deleteEvent(id);
    }

}


