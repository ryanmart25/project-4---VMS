package com.group4.vms.api.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.group4.vms.api.model.Employee;

@Repository
public class EmployeeRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Employee> getLoginInfo(String email, String password){
        return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email).and("password").is(password)), Employee.class);
        //return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email)), Employee.class);
    }

    public List<Employee> getLoginInfo(String email){ //overloaded w/o password for new accs
        return this.mongoTemplate.find(Query.query(Criteria.where("email").is(email)), Employee.class);

    }

    public boolean newEmp(Employee emp) {
        this.mongoTemplate.insert(emp, "employees");
        //if (this.mongoTemplate.find(Query.query(Criteria.where)), null)))
        return false;
    }

    public Employee getApprovalStatus(String name, String email, ObjectId id) {
        Query query = new Query(
                Criteria.where("email").is(email)
                        .and(name).is(name)
                        .and("_id").is(id));
        return this.mongoTemplate.findOne(query, Employee.class);
    }

    public Employee getApprovalStatus(String name, String email){
        //return an employee if they have been approved
        Query query = new Query(Criteria.where("name").is(name).and("email").is(email));
        return this.mongoTemplate.findOne(query, Employee.class);
    }
}
