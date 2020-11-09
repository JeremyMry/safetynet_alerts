package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.safetynet.alerts.service.PersonService;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonsController {

    @Autowired
    private PersonService personService;

    @Autowired
    private DataContainer dataContainer;

    @PostMapping("/add")
    public List<Person> addPerson(@RequestBody Person person) {
        List<Person> listPerson = this.personService.add(person);
        return listPerson;
    }

    @PutMapping("/update")
    public List<Person> updatePerson(@RequestBody Person person) {
        List<Person> listPerson = personService.update(person);
        return listPerson;

    }

    @DeleteMapping("/delete")
    public List<Person> deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        List<Person> listPersons = personService.delete(firstName, lastName);
        return listPersons;
    }
}
