package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PersonInfoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonInfoService personInfoService;

    @GetMapping("/personInfo")
    public PersonInfo getAPersonInformation(@RequestParam String firstName, String lastName) {
        PersonInfo empty = new PersonInfo();

        logger.info("Request = " + firstName + " " + lastName);
        Optional<PersonInfo> personInfoOptional = Optional.ofNullable(personInfoService.getPersonInformation(firstName, lastName));
        if(personInfoOptional.isPresent()) {
            logger.info("HTTP GET request received, SUCCESS");
            return personInfoService.getPersonInformation(firstName, lastName);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}
