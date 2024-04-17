package com.group4.vms.repository;

import com.group4.vms.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VolunteerRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Volunteer> getLoginInfo(String email, String password){
        return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email).and("password").is(password)), Volunteer.class);

    }

    public List<Volunteer> getLoginInfo(String email){ //overloaded w/o password for new accs
        return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email)), Volunteer.class);

    }

}
