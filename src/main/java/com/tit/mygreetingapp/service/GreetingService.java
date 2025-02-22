package com.tit.mygreetingapp.service;

import com.tit.mygreetingapp.entity.Greeting;
import com.tit.mygreetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Greeting updateGreetingById(Long id, String newMessage) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            Greeting greeting = optionalGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    public Map<String, String> deleteGreetingById(Long id) {
        Map<String, String> response = new HashMap<>();
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            response.put("message", "Greeting deleted successfully.");
        } else {
            response.put("message", "Greeting not found.");
        }
        return response;
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