package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.exception.GreetingAppException;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String getGreeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return greetingService.getMessage(name);
    }

    @PutMapping("/greetingParam")
    public String getGreetingByParameter(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        return greetingService.getGreetingByParameter(firstName, lastName);
    }

    @PostMapping("/create")
    public GreetingDTO saveGreeting(@RequestBody GreetingDTO greetingDTO) {
        return greetingService.saveGreeting(greetingDTO);
    }

    @GetMapping("/greetings/{id}")
    public GreetingDTO getGreetingById(@PathVariable Long id) throws GreetingAppException {
        return greetingService.getGreetingByID(id);
    }

    @GetMapping("/greetings")
    public List getAllGreetings() {
        return greetingService.getAllGreetings();
    }

}
