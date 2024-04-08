package com.group4.vms;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "volunteers")
@NoArgsConstructor
public record Volunteer(ObjectId id, String name, String email, String password, String pronouns) {}


