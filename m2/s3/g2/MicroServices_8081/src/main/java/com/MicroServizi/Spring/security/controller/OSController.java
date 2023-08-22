package com.MicroServizi.Spring.security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.MicroServizi.Spring.security.entity.Person;

@RestController
public class OSController {
	
	private final RestTemplate restTemplate;

    public OSController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/os/get-string")
    public String getString() {
        String response = restTemplate.getForObject("http://localhost:8082/app/data1", String.class);
        return "Response from Data1: " + response;
    }

    @GetMapping("/os/get-people")
    public String getPeople() {
        List<Person> people = restTemplate.getForObject("http://localhost:8082/app/data3", List.class);
        return "Response from Data3: " + people;
    }

    @GetMapping("/os/get-people-json")
    public List<Person> getPeopleJson() {
        List<Person> people = restTemplate.getForObject("http://localhost:8082/app/data3", List.class);
        return people;
    }
	
}
