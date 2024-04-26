package com.group4.vms.api.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.group4.vms.api.model.Picture;
import com.group4.vms.api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProfileService {
    //fields
    @Autowired
    ProfileRepository profileRepository;

    //constructors

    //methods
    public ResponseEntity<byte[]> getImage(String name) {
            List<Picture> pictures = this.profileRepository.findByName(name);
            if(pictures.isEmpty()){
              return ResponseEntity.notFound().build();
            }
            ResponseEntity<byte[]> response = ResponseEntity.ok(pictures.get(0).getBytes());
            response.getHeaders().set("Content-Type", "image/jpg");
            return response;
    }

    public ResponseEntity<byte[]> getInfo(String name) {
        return null;
    }
}
