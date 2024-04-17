package com.group4.vms.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "volunteers")
public class User {
    @Id
    ObjectId id;
    String name;
    String email;
    String password;
    String pronouns;
    boolean approved;
}


