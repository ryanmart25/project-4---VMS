package com.group4.vms.api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.group4.vms.api.model.Volunteer;

@Repository
public class VolunteerRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Volunteer> getLoginInfo(String email, String password){
        return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email).and("password").is(password)), Volunteer.class);
        //return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email)), User.class);
    }

    public List<Volunteer> getLoginInfo(String email){ //overloaded w/o password for new accs
        return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email)), Volunteer.class);

    }

    public boolean newVol(Volunteer vol) {
        this.mongoTemplate.insert(vol, "volunteers");
        //if (this.mongoTemplate.find(Query.query(Criteria.where)), null)))
        return false;
    }

}
