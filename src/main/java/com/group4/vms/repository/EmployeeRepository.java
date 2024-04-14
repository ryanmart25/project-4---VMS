package com.group4.vms.repository;

import com.group4.vms.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
