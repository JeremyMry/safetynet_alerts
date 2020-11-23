package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.FireAlert;
import com.safetynet.alerts.service.FireAlertService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FireAlertController {

    private final Logger logger;

    public FireAlertController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    FireAlertService fireAlertService;

    @GetMapping("/fire")
    public List<FireAlert> getPersonsByAddress(@RequestParam String address) {
        List<FireAlert> response = fireAlertService.getPersonsByAddress(address);

        logger.info("Request = /fire?address=" + address );
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
        }
        return response;
    }
}
