package com.group4.vms.controller;

import com.group4.vms.service.LoginService;
import com.group4.vms.utility.LoginState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class LoginController { // serves the login page to the user
    //fields
    //constructors
    //methods
    @GetMapping("/")
    public String getLogin() {
        return "login";
    }


    @RestController
    private static class InnerLoginController {
        //fields
        private final AtomicLong counter = new AtomicLong();
        private final LoginService service;
        //constructors
        public InnerLoginController(LoginService service){
            this.service = service;
        }

        //methods
        @GetMapping("/api/v1/verify")
        public ResponseEntity<LoginState> verifyLogin(
                @RequestParam(value = "username", defaultValue = "N/A") String email,
                @RequestParam(value = "password", defaultValue = "password") String password) {


            if(email.length() == 0 || password.length() == 0){ //this should be handled by frontend.
            return new ResponseEntity<>(new LoginState(counter.incrementAndGet(), false), HttpStatus.NO_CONTENT);
            }
            LoginState state = this.service.verifyLogin(email, password);
            if(state.loggedIn()){
                return new ResponseEntity<>(state, HttpStatus.FOUND);
            }
            else{
                return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
            }


        }

        @PostMapping("/api/v1/adduser{email}{password}{name}{pronouns}")
        public LoginState postNewUser(
        //and add the new user to the database.
                @RequestParam(value = "email", defaultValue = "example123@gmail.com") String email,
                @RequestParam(value = "password", defaultValue = "N/A") String password,
                @RequestParam( value = "name", defaultValue = "JohnDoe") String name,
                @RequestParam(value = "pronouns", defaultValue = "JohnDoe") String pronouns) {
            return this.service.addAccount(email, password, name, pronouns);
        }

    }
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
