package com.group4.vms.api.repository;

import com.group4.vms.api.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MessageRepository extends MongoRepository<Message, String> {
  //type a message
}