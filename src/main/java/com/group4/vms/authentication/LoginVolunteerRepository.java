package com.group4.vms.authentication;

import com.group4.vms.Volunteer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginVolunteerRepository extends MongoRepository<Volunteer, ObjectId> {

}
