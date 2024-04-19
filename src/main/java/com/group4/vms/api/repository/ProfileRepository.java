package com.group4.vms.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileRepository {
    //fields
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Picture> findByName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Picture.class);

    }
}
