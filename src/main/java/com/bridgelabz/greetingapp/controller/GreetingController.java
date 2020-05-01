package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = {"/", "", "/home"})
    public String sayHello() {
        return greetingService.sayHello();
    }

    @GetMapping("/getGreeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return greetingService.getMessage(name);
    }

    @PutMapping("/greetingParam")
    public Greeting getGreetingByParameter(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        return greetingService.getGreetingByParameter(firstName, lastName);
    }
}
