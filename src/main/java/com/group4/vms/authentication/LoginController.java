package com.group4.vms.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        @GetMapping("/api/v1/verify{username}{password}")
        public LoginState verifyLogin(
                @RequestParam(value = "username", defaultValue = "N/A") String email,
                @RequestParam(value = "password", defaultValue = "password") String password) {
            if(email.length() == 0 || password.length() == 0){
                return new LoginState(counter.incrementAndGet(), false);
            }
            return this.service.verifyLogin(email, password);

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
