package com.group4.vms.authentication;

import com.group4.vms.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginEmployeeRepository extends MongoRepository<Employee, ObjectId> {
}
