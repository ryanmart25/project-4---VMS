package com.group4.vms;
import org.springframework.data.mongodb.repository.*;
public interface EventRepository extends MongoRepository<String, Event>{

}
