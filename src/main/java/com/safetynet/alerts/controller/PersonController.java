package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.safetynet.alerts.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public List<Person> addPerson(@RequestBody Person person) {
        List<Person> empty = new ArrayList<>();

        logger.info("Request = " + person );
        if(!personService.add(person).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return personService.add(person);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }

    @PutMapping("/update")
    public List<Person> updatePerson(@RequestBody Person person) {
        List<Person> empty = new ArrayList<>();

        logger.info("Request = " + person );
        if(!personService.update(person).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return personService.update(person);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }

    }

    @DeleteMapping("/delete")
    public List<Person> deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        List<Person> empty = new ArrayList<>();

        logger.info("Request = " + firstName + " " + lastName );
        if(!personService.delete(firstName, lastName).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return personService.delete(firstName, lastName);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}
