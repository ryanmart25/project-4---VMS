package com.group4.vms.authentication;

import com.group4.vms.Volunteer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginVolunteerRepository extends MongoRepository<Volunteer, ObjectId> {

    //@Query("{" +
    //        "$and: [" +
    //        "{'firstname': ?0} , " +
    //        "{'password' : ?1}" +
    //        "]}")
    //public List<Volunteer> findByName(String firstname, String lastname);

    @Query("{" +
            "$and: [ " +
                "{'email' : ?0} , " +
                "{ 'password' : ?1 }" +
            "  ]" + /* actual query, ANDS the two expressions*/
            " }")
    public List<Volunteer> findByLoginInfo(String email, String password);
}
