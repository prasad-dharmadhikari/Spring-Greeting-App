package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public Greeting getMessage(String name) {
        return new Greeting(name);
    }

    public Greeting getGreetingByParameter(String name) {
        return new Greeting(name);
    }

    public String sayHello() {
        return "Hello World";
    }
}
