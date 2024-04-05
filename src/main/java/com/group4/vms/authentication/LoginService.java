package com.group4.vms.authentication;


import com.group4.vms.Employee;
import com.group4.vms.Volunteer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class LoginService {
    // fields
    private final LoginRepository loginRepository;
    private final MongoTemplate mongoTemplate;

    private AtomicLong counter = new AtomicLong();
    //constructors
    public LoginService(LoginRepository loginRepository, MongoTemplate mongoTemplate){ //dependency injection, makes testing easier b/c you can mock up a repository instead of spinning up a real instance of mongodb

        this.loginRepository = loginRepository;
        this.mongoTemplate = mongoTemplate;
    }
    //methods
    public LoginState addAccount(String email, String Password){ // TODO See if there is a better way to search the database for the Username & pAssword
        //1. check for account
        //2. add account to database
        //log the user in

        Query query = new Query()
                .addCriteria(Criteria.where("email").is(email))
                .addCriteria(Criteria.where("password").is(Password));

        List<Volunteer> loginInfos = findUser(query);
        if(!loginInfos.isEmpty()){
            return new LoginState(counter.incrementAndGet(), false);
            // a "false" login state indicates the account exists, and the operation cannot be performed. endpoint should return as such.
        }
        else{
            List<Employee> employee = findEmployee(query);
            if(!employee.isEmpty()){
                return new LoginState(counter.incrementAndGet(), false);
            }
        }
        //create the account.
        //return true for successful account creation.
        this.loginRepository.insert(new LoginInfo(new ObjectId(), email, Password));
        return new LoginState(counter.incrementAndGet(), true);

    }
    public LoginState verifyLogin(String email, String password){ //is this the correct way to implement this?
                                                                    //How do you give this user a session? how do i protect my other APIs
        //1. search for user
        //2. if user exists, good login
        //3. if user does not exist, bad login
        Query query = new Query()
                .addCriteria(Criteria.where("email").is(email))
                .addCriteria(Criteria.where("password").is(password));

        List<Employee> employees= findEmployee(query); //search employees
        if(employees.isEmpty()){
            List<Volunteer> volunteers= findUser(query); //search volunteers
            if(!volunteers.isEmpty())
                return new LoginState(counter.incrementAndGet(), true);
        }
        else{
            return new LoginState(counter.incrementAndGet(), true);
        }
        return new LoginState(counter.incrementAndGet(), false);
    }

    //utility methods to support the service methods
    private List<Volunteer> findUser(Query query){

        return this.mongoTemplate.find(query, Volunteer.class);
    }
    private List<Employee> findEmployee(Query query){
        return this.mongoTemplate.find(query, Employee.class);
    }

}
