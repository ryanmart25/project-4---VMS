package com.group4.vms.repository;


import com.group4.vms.model.Entry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimesheetRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Entry> getAllEntries(){
        return null;

    }
    public List<Entry> getEntries(ObjectId[] entries){
        return null;
    }
    public Entry getEntry(ObjectId id){
        return null;
    }
    public void postEntries(List<Entry> entries){
    }
    public void patchEntry(ObjectId id){

    }
    public void patchEntries(ObjectId[] ids){

    }
}
