package com.group4.vms.api.controller;

import com.group4.vms.api.service.LoginService;
import com.group4.vms.api.utility.LoginState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.concurrent.atomic.AtomicLong;
@CrossOrigin(origins = "http://localhost:63342")
@RestController
public class LoginController {
    //fields
    private final AtomicLong counter = new AtomicLong();

    private final LoginService service;
    //constructors
    public LoginController(LoginService service){
        this.service = service;
    }

    //methods
    @GetMapping("/api/v1/verify")
    public ResponseEntity<LoginState> verifyLogin(
            @RequestParam(value = "username", defaultValue = "N/A") String email,
            @RequestParam(value = "password", defaultValue = "password") String password) {



        LoginState state = this.service.verifyLogin(email, password);
        System.out.println(state);
        if(state.loggedIn()){
            return new ResponseEntity<>(state, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/api/v1/newVolunteer")
    public ResponseEntity<LoginState> postNewVol(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "pronouns") String pronouns) {

        LoginState state = this.service.addVolunteer(name, email);
        if(state.loggedIn()){
            return new ResponseEntity<>(state, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/v1/newEmploee")
    public ResponseEntity<LoginState> postNewEmp(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "pronouns") String pronouns) {

        LoginState state = this.service.addEmployee(name, email);
        if(state.loggedIn()){
            return new ResponseEntity<>(state, HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
        }
    }
/*
    @PostMapping("/api/v1/adduser{email}{password}{name}{pronouns}")
    public LoginState postNewUser(
            //and add the new user to the database.
            @RequestParam(value = "email", defaultValue = "example123@gmail.com") String email,
            @RequestParam(value = "password", defaultValue = "N/A") String password,
            @RequestParam( value = "name", defaultValue = "JohnDoe") String name,
            @RequestParam(value = "pronouns", defaultValue = "JohnDoe") String pronouns) {
        return this.service.addAccount(email, password, name, pronouns);
    }
*/
}

// The following code accepted a URL query parameter and showed it to the user
// in the form of "Hello, <param> !"
// private static final String template = "Hello, %s!";
// private final AtomicLong counter = new AtomicLong();
// public GreetingService greetingService;

// @GetMapping
// public Greeting getGreeting(@RequestParam(value = "name", defaultValue =
// "World") String name) { // Parameter syntax
// // will be
// // /?name=dave
// return new Greeting(counter.incrementAndGet(), String.format(template,
// name));
// }
