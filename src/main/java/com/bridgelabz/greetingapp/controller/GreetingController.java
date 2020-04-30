package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping("/getGreeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(name);
    }

    @PutMapping("/greetingParam/{name}")
    public Greeting getGreetingByParameter(@PathVariable String name) {
        return new Greeting(name);
    }
}
