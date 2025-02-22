package com.tit.mygreetingapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/get")
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello! This is a GET request.");
        return response;
    }

    @PostMapping("/post")
    public Map<String, String> createGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "POST request received.");
        response.put("data", request.getOrDefault("name", "No name provided"));
        return response;
    }

    @PutMapping("/put")
    public Map<String, String> updateGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "PUT request received.");
        response.put("data", request.getOrDefault("name", "No name provided"));
        return response;
    }

    @DeleteMapping("/delete")
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "DELETE request received.");
        return response;
    }
}

