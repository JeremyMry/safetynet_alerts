package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonInfoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonInfoService personInfoService;

    @GetMapping("/personInfo")
    public PersonInfo getPersonInformations(@RequestParam String firstName, String lastName) {
        logger.info("eee");
        return personInfoService.getPersonInformations(firstName, lastName);
    }
}
