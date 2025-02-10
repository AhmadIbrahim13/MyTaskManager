package com.example.demo.repository;

import com.example.demo.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//for crud operations on mongodb
//manages Event objects in mongodb
public interface EventRepository extends MongoRepository<Event,String> {

    List<Event> findByName(String name);


    //mongodb query to find events by their type
    @Query("{type: ?0 }")
    List<Event> getEventByType(String type);

}
