package com.group4.vms.api.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.group4.vms.api.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/api/v1/getProfilePicture")
    public ResponseEntity<byte[]>  getImage(@RequestParam(value = "name") String name) {
        return this.profileService.getImage(name);
    }
    @GetMapping("/api/v1/getInfo")
    public ResponseEntity<byte[]> getProfileInfo(String name){
        return this.profileService.getInfo(name);
    }
}
