package com.group4.vms.api.repository;

import com.group4.vms.api.model.Employee;
import com.group4.vms.api.model.Entry;
import com.group4.vms.api.model.Picture;
import com.group4.vms.api.model.Volunteer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProfileRepository {
    //fields
    @Autowired
    MongoTemplate mongoTemplate;

    private static byte[] getDefaultIcon(){
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new File("../../"));
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(icon, "png", stream);
            return stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[]{0};
        }

    }

    public byte[] getImageByName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        List<Picture> pictures = mongoTemplate.find(query, Picture.class);
        byte[] bytes;
        if(pictures.isEmpty()){
            bytes = getDefaultIcon();
        }
        else{
            bytes = pictures.get(0).getBytes();
        }
        return bytes;

    }
    public String[] getVolunteerProfileInfoByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Volunteer vol = this.mongoTemplate.findOne(query, Volunteer.class);
        if(vol!=null){
            String[] info = new String[4]; //name, email, pronouns, time volunteered
            info[0] = vol.getName();
            info[1] = vol.getEmail();
            info[2] = vol.getPronouns();

            double aggregatedTime = this.getAggregateTime(info[0]);
            return info;
        }
        else
            return new String[]{"N/A", "N/A", "N/A", "N/A"};
    }

    private double getAggregateTime(String name){
        Query query = new Query(Criteria.where("name").is(name));
        double aggregatetime = 0.0;
        aggregatetime = Arrays.stream(this.mongoTemplate.find(query, Entry.class).get(0).getTimeVolunteered()).sum();
        return aggregatetime;
    }

    public String[] getVolunteerProfileInfoByObjectID(ObjectId id){
        Volunteer vol = this.mongoTemplate.findById(id, Volunteer.class);
        if(vol!=null){
            String[] info = new String[4]; //name, email, pronouns, time volunteered
            info[0] = vol.getName();
            info[1] = vol.getEmail();
            info[2] = vol.getPronouns();

            double aggregatedTime = this.getAggregateTime(info[0]);
            return info;
        }
        else
            return new String[]{"N/A", "N/A", "N/A", "N/A"};
    }

    public String[] setEmployeeInfo(ObjectId id, String pronouns, String name) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("pronouns", pronouns);
        update.set("name", name);

        Employee b = this.mongoTemplate.findAndModify(query, update,Employee.class, "employees");
        if(b!= null){
            return b.toArray();
        }
        else{
            return new String[]{"N/A","N/A","N/A","N/A","N/A","N/A"};
        }

    }
    public String[] setVolunteerInfo(ObjectId id,  String pronouns, String name) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("pronouns", pronouns);
        update.set("name", name);

    Volunteer b = this.mongoTemplate.findAndModify(query, update,Volunteer.class, "volunteers");
        if(b!= null){
            return b.toArray();
        }
        else{
            return new String[]{"N/A","N/A","N/A","N/A","N/A","N/A"};
        }
    }

}

