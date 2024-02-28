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

    // The following code attempts to show the user an html file when the user
    // visits an endpoint.
    public LoginService loginService;
    private AtomicLong counter = new AtomicLong();

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/verify{username}{password}")
    public String verifyLogin(@RequestParam(value = username, defaultValue = "N/A"), @RequestParam(value = password, defaultValue = "N/A"), String Username, String password){
        loginService.verify(counter.incrementAndGet(), String.format(, null))           
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
}
