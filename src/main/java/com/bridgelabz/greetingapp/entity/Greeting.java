package com.bridgelabz.greetingapp.entiry;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.*;

public class Greeting {

    int id;
    String firstName;
    String lastName;
    String greetingMessage;

}
