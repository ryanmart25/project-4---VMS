package com.group4.vms;
import com.mongodb.client.FindIterable;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.*;
import com.mongodb.client.MongoCollection.*;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, ObjectId>{

}
