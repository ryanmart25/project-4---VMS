package com.group4.vms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group4.vms.model.Message;


public interface MessageRepository extends MongoRepository<Message, String> {
  //type a message
}