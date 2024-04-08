package com.group4.vms.authentication;

import java.util.concurrent.atomic.AtomicLong;

import com.group4.vms.authentication.LoginService;
import com.group4.vms.authentication.LoginState;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController { // serves the login page to the user

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }


    @RestController
    private static class InnerLoginController {
        private AtomicLong counter = new AtomicLong();
        private final LoginService service;
        public InnerLoginController(LoginService service){
            this.service = service;
        }
        @GetMapping("/api/v1/verify{username}{password}")
        public LoginState verifyLogin(
                @RequestParam(value = "username", defaultValue = "N/A") String email,
                @RequestParam(value = "password", defaultValue = "password") String password) {
            return this.service.verifyLogin(email, password);

        }

        @PostMapping("/api/v1/adduser{email}{password}{name}{pronouns}")
        public LoginState postNewUser( //TODO This needs to be fully fleshed out, add error correction, and feed all parameters to the constructor,
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
