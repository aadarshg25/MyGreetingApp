package com.tit.mygreetingapp.controller;

import com.tit.mygreetingapp.entity.Greeting;
import com.tit.mygreetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Map<String, String> request) {
        return greetingService.saveGreeting(request.getOrDefault("message", "Hello World!"));
    }

    @GetMapping("/get")
    public Map<String, String> getGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        Map<String, String> request = Map.of(
                "firstName", firstName != null ? firstName : "",
                "lastName", lastName != null ? lastName : ""
        );
        return greetingService.getGreeting(request);
    }

    @PostMapping("/post")
    public Map<String, String> createGreeting(@RequestBody Map<String, String> request) {
        return greetingService.getGreeting(request);
    }

    @PutMapping("/put")
    public Map<String, String> updateGreeting(@RequestBody Map<String, String> request) {
        return greetingService.getGreeting(request);
    }

    @DeleteMapping("/delete")
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "DELETE request received.");
        return response;
    }
}


