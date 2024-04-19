package com.group4.vms.api.service;


import com.group4.vms.api.repository.Picture;
import com.group4.vms.api.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Service
public class ProfileService {
    //fields
    @Autowired
    ProfileRepository profileRepository;
    //constructors

    //methods
    public byte[] getImage(String name) throws IOException {
            List<Picture> pictures = this.profileRepository.findByName(name);
            return pictures.get(0).getBytes();
    }
}
