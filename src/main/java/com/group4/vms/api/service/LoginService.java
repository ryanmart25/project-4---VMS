package com.group4.vms.api.service;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.vms.api.model.Employee;
import com.group4.vms.api.model.User;
import com.group4.vms.api.model.Volunteer;
import com.group4.vms.api.repository.EmployeeRepository;
import com.group4.vms.api.repository.VolunteerRepository;
import com.group4.vms.api.utility.LoginState;
@Service
public class LoginService {
    // fields

    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final VolunteerRepository volunteerRepository;
   // private final MongoTemplate mongoTemplate;

    private final AtomicLong counter = new AtomicLong();
    //constructors
   public LoginService(VolunteerRepository volunteerRepository, EmployeeRepository employeeRepository){ //dependency injection, makes testing easier b/c you can mock up a repository instead of spinning up a real instance of mongodb

        this.volunteerRepository = volunteerRepository;
        //this.mongoTemplate = mongoTemplate;
        this.employeeRepository = employeeRepository;
    }
    //methods
    public LoginState addVolunteer(String name, String email, String password, String pronouns){ // TODO See if there is a better way to search the database for the Username & pAssword
        //1. check for account
        //2. add account to database
        //log the user in
        List<Volunteer> vols = this.volunteerRepository.getLoginInfo(email);
        for(Volunteer v : vols){
            if(v.getEmail().equals(email)){
                return new LoginState(counter.incrementAndGet(), false);
            }
            Volunteer nVol = new Volunteer(new ObjectId(), name, email, password, pronouns);
            volunteerRepository.newVol(nVol);
        }

        return new LoginState(counter.incrementAndGet(), false);
    }


    public LoginState addEmployee(String name, String email, String password, String pronouns){ // TODO See if there is a better way to search the database for the Username & pAssword
        //1. check for account
        //2. add account to database
        //log the user in
        List<Employee> emps = this.employeeRepository.getLoginInfo(email);
        for(Employee e : emps){
            if(e.getEmail().equals(email)){
                return new LoginState(counter.incrementAndGet(), false);
            }
            Employee nEmp = new Employee(new ObjectId(), name, email, password, pronouns, true, false);
            employeeRepository.newEmp(nEmp);
        }

        return new LoginState(counter.incrementAndGet(), false);

    }
    public LoginState verifyLogin(String email, String password){ //is this the correct way to implement this?
                                                                    //How do you give this user a session? how do i protect my other APIs
        //verification: string
        if(email.matches("/w+[@]/w+[.]/w{3,}")){//ensuring the email string matches a general email string format:
            //1 or more characters, followed by an '@',  followed by a domain name.

            //1. search for user
            //2. if user exists, good login
            //3. if user does not exist, bad login
            List<Employee> employees = this.employeeRepository.getLoginInfo(email, password);
            List<Volunteer> users = this.volunteerRepository.getLoginInfo(email, password);

            if(employees.isEmpty() && users.isEmpty()){
                return new LoginState(counter.incrementAndGet(), false);
            }
            else {
                for (Employee employee : employees) {
                    if(employee.isApproved()){
                        return new LoginState(counter.incrementAndGet(), true);
                        }
                    else{
                        return new LoginState(counter.incrementAndGet(), false);
                    }
                }
                for (User user : users) {
                    if(user.isApproved()) {
                        return new LoginState(counter.incrementAndGet(), true);
                        }
                    else {
                        return new LoginState(counter.incrementAndGet(), false);
                    }
                }
            }
        }
        else{ //email provided does not match a general email string format. send bad login.
            return new LoginState(counter.incrementAndGet(), false);
        }

        return new LoginState(counter.incrementAndGet(), false);
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
