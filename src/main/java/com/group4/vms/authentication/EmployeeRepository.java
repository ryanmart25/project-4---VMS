package com.group4.vms.authentication;

import com.group4.vms.Employee;
import com.group4.vms.Volunteer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWarDeployment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Employee> getLoginInfo(String email, String password){
        return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email).and("password").is(password)), Employee.class);

    }
}
