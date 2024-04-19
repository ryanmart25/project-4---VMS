package com.group4.vms.api.controller;

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
    private final String noImageIconPath = "../../../../resources/noImage.jpg";
    @Autowired
    ProfileService profileService;
    byte[] noImageIcon;

    //constructors
    public ProfileController(ProfileService service){ //basic dependency injection.
        this.profileService = service;
    }
    @GetMapping("/api/v1/getProfilePicture")
    public ResponseEntity<byte[]>  getImage(@RequestParam(value = "name") String name) {
        try {
                ResponseEntity<byte[]> responseEntity = ResponseEntity.ok(this.profileService.getImage(name));
         responseEntity.getHeaders().set("Content-Type", "image/jpg");
         return responseEntity;
        }
        catch(IOException e){
            BufferedImage image = null;
            try{
                image = ImageIO.read(new File(noImageIconPath));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return ResponseEntity.internalServerError().build();
        }
    }
}
