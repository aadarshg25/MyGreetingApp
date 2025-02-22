package com.tit.mygreetingapp.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

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


