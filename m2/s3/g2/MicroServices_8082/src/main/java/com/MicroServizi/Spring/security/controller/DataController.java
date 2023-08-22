package com.MicroServizi.Spring.security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroServizi.Spring.security.entity.Person;

@RestController
public class DataController {
	
	@GetMapping("/app/data1")
    public String getData1() {
        return "Response from Data1";
    }

    @GetMapping("/app/data2")
    public List<String> getData2() {
        return new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4"));
    }

    @GetMapping("/app/data3")
    public List<Person> getData3() {
        return Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 28),
            new Person("David", 22)
        );
    }
	
}
