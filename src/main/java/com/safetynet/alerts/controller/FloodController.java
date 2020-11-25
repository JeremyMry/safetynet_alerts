package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Household;
import com.safetynet.alerts.service.FloodService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class FloodController {

    private final Logger logger;

    public FloodController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    FloodService floodService;

    @GetMapping("/flood/stations")
    public List<Household> getHouseholdByFireStationAddress(@RequestParam String stations) {
        List<Household> response = floodService.getHouseholdByStationAddress(stations);

        logger.info("Request = /flood/stations?stations=" + stations );
        // If the response list is empty, it means that the request is correct but the parameter doesn't match with anything the json file
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
        }
        return response;
    }
}
