package com.tit.mygreetingapp.service;

import com.tit.mygreetingapp.entity.Greeting;
import com.tit.mygreetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public Greeting findGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Map<String, String> getGreeting(Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        String firstName = request.getOrDefault("firstName", "").trim();
        String lastName = request.getOrDefault("lastName", "").trim();

        String greetingMessage;
        if (!firstName.isEmpty() && !lastName.isEmpty()) {
            greetingMessage = "Hello " + firstName + " " + lastName + "!";
        } else if (!firstName.isEmpty()) {
            greetingMessage = "Hello " + firstName + "!";
        } else if (!lastName.isEmpty()) {
            greetingMessage = "Hello " + lastName + "!";
        } else {
            greetingMessage = "Hello World!";
        }

        response.put("message", greetingMessage);
        return response;
    }
}