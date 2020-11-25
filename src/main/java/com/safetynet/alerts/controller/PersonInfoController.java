package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonInfoController {

    private final Logger logger;

    public PersonInfoController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    PersonInfoService personInfoService;

    @GetMapping("/personInfo")
    public List getAPersonInformation(@RequestParam String firstName, String lastName) {
        List<PersonInfo> response = personInfoService.getPersonInformation(firstName, lastName);
        List<String> error = new ArrayList<>();
        error.add("The request '" + firstName + "' or '" + lastName + "' doesn't match anything or is incorrect");

        logger.info("Request = /personInfo?firstName=" + firstName + "&lastName=" + lastName);
        // If response.getFirstName and response.getLastName are null it means that the request is correct but the parameters doesn't match with anything the json file
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, ERROR / Response = " + response.toString());
            return response;
        } else {
            logger.error("HTTP GET request received, SUCCESS / Response = " + response.toString());
            return error;
        }
    }
}
