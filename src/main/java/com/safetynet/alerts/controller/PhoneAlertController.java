package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.PhoneAlertService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhoneAlertController {

    private final Logger logger;

    public PhoneAlertController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    PhoneAlertService phoneAlertService;

    @GetMapping("/phoneAlert")
    public List<String> getPhoneNumbersByCoverageStation(@RequestParam String firestation) {
        List<String> response = phoneAlertService.getPhoneNumberByCoverage(firestation);

        // Show the request
        logger.info("Request = /phoneAlert?firestation=" + firestation );
        // If the response list is empty, it means that the request is correct but the parameter doesn't match with anything the json file
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response =" + response.toString());
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
        }
        return response;
    }

}
