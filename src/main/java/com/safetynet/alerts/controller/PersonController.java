package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.Person;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.safetynet.alerts.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {

    private final Logger logger;

    public PersonController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public List<Person> addPerson(@RequestBody Person person) {
        List<Person> response = personService.add(person);

        logger.info("Request = " + person );
        if(!response.isEmpty()) {
            logger.info("HTTP POST request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP POST request received, ERROR / Response = " + response.toString());
        }
        return response;
    }

    @PutMapping("/update")
    public List<Person> updatePerson(@RequestBody Person person) {
        List<Person> response = personService.update(person);

        logger.info("Request = " + person );
        if(!personService.update(person).isEmpty()) {
            logger.info("HTTP PUT request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP PUT request received, ERROR / Response = " + response.toString());
        }
        return response;
    }

    @DeleteMapping("/delete")
    public List<Person> deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        List<Person> response = personService.delete(firstName, lastName);

        logger.info("Request = " + firstName + " " + lastName );
        if(!response.isEmpty()) {
            logger.info("HTTP DELETE request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP DELETE request received, ERROR / Response = " + response.toString());
        }
        return response;
    }
}
