package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.service.ChildAlertService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChildAlertController {

    private final Logger logger;

    ChildAlertController(final Logger logger)
    {
        this.logger = logger;
    }

    @Autowired
    ChildAlertService childAlertService;

    @GetMapping("/childAlert")
    public List getChildByAddress(@RequestParam String address) {
        List<ChildAlert> response = childAlertService.getChildByAddress(address);
        List<String> error = new ArrayList<>();
        error.add("The request '" + address + "' doesn't match anything or is incorrect");

        logger.info("Request = /childAlert?address=" + address);
        // If the response list is empty, it means that the request is correct but the parameter doesn't match with anything the json file
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response = " + response.toString());
            return response;
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
            return error;
        }
    }
}
