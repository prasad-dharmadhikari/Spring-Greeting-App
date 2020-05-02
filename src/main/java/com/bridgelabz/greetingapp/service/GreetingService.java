package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingDTO;
import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.exception.GreetingAppException;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    GreetingRepository greetingRepository;
    @Autowired
    ModelMapper modelMapper;

    public String getMessage(String name) {
        return "Hello " + name;
    }

    public String getGreetingByParameter(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    public String sayHello() {
        return "Hello World";
    }

    public GreetingDTO saveGreeting(GreetingDTO greetingDTO) {
        greetingDTO.setGreetingMessage("Hello " + greetingDTO.getFirstName() + " " + greetingDTO.getLastName());
        Greeting greeting = modelMapper.map(greetingDTO, Greeting.class);
        greetingRepository.save(greeting);
        greetingDTO.setId(greeting.getId());
        return greetingDTO;
    }

    public GreetingDTO getGreetingByID(Long id) throws GreetingAppException {
        Greeting greeting = greetingRepository.getOne(id);
        if (greeting == null)
            throw new GreetingAppException(GreetingAppException.ExceptionType.DATA_NOT_FOUND,"DATA NOT FOUND");
        GreetingDTO greetingDTO = modelMapper.map(greeting, GreetingDTO.class);
        return greetingDTO;
    }

    public List getAllGreetings() {
        return greetingRepository.findAll();
    }

    public GreetingDTO updateGreetingInfo(GreetingDTO greetingDTO) {
        greetingDTO.setGreetingMessage("Hello " + greetingDTO.getFirstName() + " " + greetingDTO.getLastName());
        Greeting greeting = modelMapper.map(greetingDTO, Greeting.class);
        greetingRepository.save(greeting);
        return greetingDTO;
    }
}
