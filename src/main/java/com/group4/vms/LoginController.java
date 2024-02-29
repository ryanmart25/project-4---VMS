package com.group4.vms;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController { // serves the login page to the user
    private String[] usernames = {
            "dave",
            "John",
            "qwertydopop"
    };
    private String[] passwords = {
            "123",
            "abc",
            "qwerty"
    };

    private boolean exists(String user, String[] usernames) {
        for (int i = 0; i < usernames.length; i++) {
            if (user.equals(usernames[i])) {
                return true;
            }
        }
        return false;
    }
    // The following code attempts to show the user an html file when the user
    // visits an endpoint.
    // public LoginService loginService;
    // private AtomicLong counter = new AtomicLong();

    // public LoginController(LoginService loginService) {
    // this.loginService = loginService;
    // }

    @RestController
    private class InnerLoginController {
        private AtomicLong counter = new AtomicLong();

        @GetMapping("/verify{username}{password}")
        public Login verifyLogin(
                @RequestParam(value = "username", defaultValue = "N/A") String username,
                @RequestParam(value = "password", defaultValue = "password") String password) {
            boolean bool = exists(username, usernames);
            boolean bool2 = exists(password, passwords);
            if (bool && bool2) {
                return new Login(counter.incrementAndGet(), true);
            } else {
                return new Login(counter.incrementAndGet(), false);
            }

        }

        @GetMapping("/")
        public String getLogin() {
            return "login";
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
