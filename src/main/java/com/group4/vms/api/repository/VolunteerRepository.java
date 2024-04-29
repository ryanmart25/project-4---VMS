package com.group4.vms.api.repository;

import com.group4.vms.api.model.Volunteer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VolunteerRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    private final String[] emails = {"example123@csus.edu"};
    private final String[] passwords = {"qwerty123"};
    public List<Volunteer> getLoginInfo(String email, String password){
        List<Volunteer> volunteers = new ArrayList<>();
        if(emails[0].equals(email) && passwords[0].equals(password)){
            volunteers.add(new Volunteer(new ObjectId(), "John", email, password, "he/him"));
        }
        return volunteers;
        //return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email).and("password").is(password)), Volunteer.class);
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
