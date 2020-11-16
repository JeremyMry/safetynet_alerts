package com.safetynet.alerts.controller.crud;


import com.safetynet.alerts.model.crud.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.safetynet.alerts.service.crud.PersonService;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public List<Person> addPerson(@RequestBody Person person) {
        logger.info("rrr");
        return this.personService.add(person);
    }

    @PutMapping("/update")
    public List<Person> updatePerson(@RequestBody Person person) {
        logger.info("rrr");
        return personService.update(person);

    }

    @DeleteMapping("/delete")
    public List<Person> deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        logger.info("rrr");
        return personService.delete(firstName, lastName);
    }
}
