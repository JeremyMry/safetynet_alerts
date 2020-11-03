package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.Model;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.safetynet.alerts.service.PersonService;

import java.util.List;

@RestController
public class PersonsController {

    @Autowired
    private PersonService personService;

    @Autowired
    private Model model;

    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return model.getPersons();
    }
}
