package com.group4.vms.api.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "profilepictures")
@AllArgsConstructor
public class Picture {
    @Id
    ObjectId id;
    String name;
    byte[] bytes;
}
