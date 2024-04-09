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
    private final LoginVolunteerRepository loginVolunteerRepository;
    private final MongoTemplate mongoTemplate;
    private final LoginEmployeeRepository loginEmployeeRepository;
    private final AtomicLong counter = new AtomicLong();
    //constructors
    public LoginService(LoginVolunteerRepository loginVolunteerRepository, MongoTemplate mongoTemplate, LoginEmployeeRepository loginEmployeeRepository){ //dependency injection, makes testing easier b/c you can mock up a repository instead of spinning up a real instance of mongodb

        this.loginVolunteerRepository = loginVolunteerRepository;
        this.mongoTemplate = mongoTemplate;
        this.loginEmployeeRepository = loginEmployeeRepository;
    }
    //methods
    public LoginState addAccount(String name, String email, String password, String pronouns){ // TODO See if there is a better way to search the database for the Username & pAssword
        //1. check for account
        //2. add account to database
        //log the user in

        Query query = new Query()
                .addCriteria(Criteria.where("email").is(email))
                .addCriteria(Criteria.where("password").is(password));

        List<Volunteer> loginInfos = findUser(query);
        if(!loginInfos.isEmpty()){ //check if the account exists
            return new LoginState(counter.incrementAndGet(), false);
            // a "false" login state indicates the account exists, and the operation cannot be performed. endpoint should return as such.
        }
        else{ //if the account doesn't exist...
            List<Employee> employee = findEmployee(query); //search for the account in the list of employees.
            if(!employee.isEmpty()){ //if the account exists...
                return new LoginState(counter.incrementAndGet(), false);
            }
        }
        //create the account.
        //return true for successful account creation.
        this.loginVolunteerRepository.insert(new Volunteer(new ObjectId(), name, email, password, pronouns));
        return new LoginState(counter.incrementAndGet(), true);

    }
    public LoginState verifyLogin(String email, String password){ //is this the correct way to implement this?
                                                                    //How do you give this user a session? how do i protect my other APIs
        //1. search for user
        //2. if user exists, good login
        //3. if user does not exist, bad login
        List<Employee> employees = this.loginEmployeeRepository.findloginInfo(email, password);
        List<Volunteer> volunteers = this.loginVolunteerRepository.findLoginInfo(email, password);

        if(employees.isEmpty() && volunteers.isEmpty()){
            return new LoginState(counter.incrementAndGet(), false);
        }
        else {
            return new LoginState(counter.incrementAndGet(), true);
        }
    }

    ////utility methods to support the service methods
    //private List<Volunteer> findUser(Query query){
    //
    //    return this.mongoTemplate.find(query, Volunteer.class);
    //}
    //private List<Employee> findEmployee(Query query){
    //    return this.mongoTemplate.find(query, Employee.class);
    //}

}
