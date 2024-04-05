package com.group4.vms.authentication;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record LoginInfo(@Id ObjectId id, String username, String password) {}
