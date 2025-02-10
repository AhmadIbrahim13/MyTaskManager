
//managed by sprig
package com.example.demo.sevice;


import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;   //for generating unique ids

@Service              //means that this class is service in spring
public class EventService {
    @Autowired      //to know where to search
    private EventRepository repository;

    public Event addTask(Event task)     //CREATE operation
    {
        task.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    //READ operation all events
    public List<Event> findAll(){
        return repository.findAll();
    }


    public Event getEventByEventID(String eventID)
    {
        return repository.findById(eventID).get();
    }

    public List<Event> getEventByName (String name)
    {
        return repository.findByName(name);
    }

    public List<Event> getEventByType(String type)
    {
        return repository.getEventByType(type);
    }

    //UPDATE operation
    public Event updateEvent(Event eventRequest)
    {
        Event existingEvent= repository.findById(eventRequest.getId()).get();
        existingEvent.setName(eventRequest.getName());
        existingEvent.setType(eventRequest.getType());
        existingEvent.setLocation(eventRequest.getLocation());
        existingEvent.setCapacity(eventRequest.getCapacity());
        return repository.save(existingEvent);
    }

    //DELETE operation (by id)
    public String deleteEvent(String eventID){
        repository.deleteById(eventID);

        return eventID+" event is deleted from dashboard";
    }


}
