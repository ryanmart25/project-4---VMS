package com.group4.vms.authentication;

import com.group4.vms.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginEmployeeRepository extends MongoRepository<Employee, ObjectId> {

    //In-operational. MongoDB has no document with fields "firstname" , "lastname"
    @Query("{" +
            "$and: [" +
            "{'firstname': ?0} , " +
            "{'password' : ?1}" +
            "]}")
    public List<Employee> findByName(String firstname, String lastname);
    //queries database, looking for employees with the same first name and lastname.

    @Query("{" +
            "$and: [ " +
            "{'email' : ?0} , " +
            "{ 'password' : ?1 }" +
            "  ]" + /* actual query, ANDS the two expressions*/
            " }")
    public List<Employee> findloginInfo(String email, String password);
    //queries database, looking for employees with the same eail and password as the ones provided.


}
