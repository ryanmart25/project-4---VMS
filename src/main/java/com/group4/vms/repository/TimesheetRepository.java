
package com.group4.vms.repository;

import com.group4.vms.model.Entry;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimesheetRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Entry> getAllEntries() {
        return mongoTemplate.findAll(Entry.class);
    }

    public List<Entry> getEntries(ObjectId[] entryIds) {
        Query query = new Query(Criteria.where("_id").in((Object[]) entryIds));
        return mongoTemplate.find(query, Entry.class);
    }
    


    
    public Entry getEntry(ObjectId id) {
        return mongoTemplate.findById(id, Entry.class);
    }

    public void postEntries(List<Entry> entries) {
        mongoTemplate.insertAll(entries);
    }

   
    public void patchEntry(ObjectId id, Entry updatedEntry) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        
        update.push("timeVolunteered", updatedEntry.getTimeVolunteered().toArray());
        mongoTemplate.updateFirst(query, update, Entry.class);
    }
    
    public void patchEntries(ObjectId[] ids, List<Entry> updatedEntries) {
        for (Entry updatedEntry : updatedEntries) {
            Query query = new Query(Criteria.where("_id").in((Object[]) ids));
            Update update = new Update();
           
            update.push("timeVolunteered", updatedEntry.getTimeVolunteered().toArray());
            mongoTemplate.updateMulti(query, update, Entry.class);
        }
    }
    
}

