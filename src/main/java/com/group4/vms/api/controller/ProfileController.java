package com.group4.vms.api.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.group4.vms.api.service.ProfileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class ProfileController {
    //fields

    @Autowired
    ProfileService profileService;
    byte[] noImageIcon;

    //constructors
    public ProfileController(ProfileService service){ //basic dependency injection.
        this.profileService = service;
    }

@PostMapping("/api/v1/setVolunteerInfo")
public ResponseEntity<String[]> setVolunteerInfo(
        @RequestParam(value="pronouns", defaultValue = "N/A") String pronouns,
        @RequestParam(value="newname",  defaultValue = "N/A") String name,
        @RequestParam(value = "id") ObjectId id

){
        String[] ret = this.profileService.setVolunteerInfo(id, name, pronouns);
    if(arrayIsEmpty(ret, "N/A"))
        return ResponseEntity.notFound().build();
    else
        return ResponseEntity.ok(ret);
}
    @PostMapping("/api/v1/setEmployeeInfo")
    public ResponseEntity<String[]> setEmployeeInfo(
            @RequestParam(value="pronouns", defaultValue = "N/A") String pronouns,
            @RequestParam(value="newname",  defaultValue = "N/A") String name,
            @RequestParam(value = "id") ObjectId id

    ){

        String[] ret = this.profileService.setEmployeeInfo(pronouns, name, id);
        if(arrayIsEmpty(ret, "N/A"))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(ret);
    }


    @GetMapping("/api/v1/getProfilePicture")
    public ResponseEntity<byte[]>  getImage(@RequestParam(value = "name") String name) {
        if(!this.verification(name)){
            return ResponseEntity.badRequest().build();
        }
        else{
            return this.profileService.getImage(name);
        }

    }
    @GetMapping("/api/v1/getInfo")
    public ResponseEntity<String[]> getProfileInfo(@RequestParam(value = "id") ObjectId id, @RequestParam(required = false, value = "name", defaultValue = "N") String name){
        if(!this.verification(name)){
            return ResponseEntity.notFound().build();
        }
        else{
            if(name.contentEquals("N")){
                String[] info = this.profileService.getInfoByID(id);
                if(info[0].equals("N/A")){
                    return ResponseEntity.notFound().build();
                }
                else{
                    return ResponseEntity.ok(info);
                }
            }
            else{
                String[] info = this.profileService.getInfo(name);
                if(info[0].equals("N/A")){
                    return ResponseEntity.notFound().build();
                }
                else{
                    return  ResponseEntity.ok(info);
                }
            }
        }

    }
    private boolean verification(String name){
        if(name.length() < 3){
            return false;
        }
        return !name.contains("1234567890-=_+`~!@#$%^&*(),./<>?;:'\"[]{}\\|");
    }
    private boolean arrayIsEmpty(String[] array, String emptySignifier){
        return array[0].equals(emptySignifier);
    }
}
