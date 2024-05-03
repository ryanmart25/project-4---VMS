package com.group4.vms.api.service;


import com.group4.vms.api.repository.ProfileRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    //fields
    @Autowired
    ProfileRepository profileRepository;

    //constructors

    //methods
    public ResponseEntity<byte[]> getImage(String name) {
            byte[] pictures = this.profileRepository.getImageByName(name);
            if(pictures[0] == 0){
              return ResponseEntity.notFound().build();
            }
            ResponseEntity<byte[]> response = ResponseEntity.ok(pictures);
            response.getHeaders().set("Content-Type", "image/png");
            return response;
    }

    public String[] getInfoByID(ObjectId id) {
        return this.profileRepository.getVolunteerProfileInfoByObjectID(id);
    }

    public String[] getInfo(String name) {
        return this.profileRepository.getVolunteerProfileInfoByName(name);
    }
//for employees
    public String[] setEmployeeInfo(String pronouns, String name, ObjectId id) {
        return this.profileRepository.setEmployeeInfo(id, pronouns, name);
    }


    //for volunteers
    public String[] setVolunteerInfo(ObjectId id, String pronouns, String name) {
    //need to set up regex to figure out if this is a name or
   return this.profileRepository.setVolunteerInfo(id,pronouns, name );
    }
}
