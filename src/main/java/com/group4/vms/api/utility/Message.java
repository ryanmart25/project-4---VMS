package com.group4.vms.api.utility;

import org.bson.types.ObjectId;

import java.sql.Timestamp;

public record Message(ObjectId Recipient, ObjectId Sender, String Body, Timestamp timestamp) {

}
