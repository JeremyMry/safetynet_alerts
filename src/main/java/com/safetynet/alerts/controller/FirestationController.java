package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.FirestationService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

    private final Logger logger;

    public FirestationController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    FirestationService firestationService;

    @PostMapping("/add")
    public List<Firestation> addFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.add(firestation);

        logger.info("Request = " + firestation );
        logger.info("HTTP POST request received, SUCCESS / Response = " + response.toString());
        return response;
    }

    @PutMapping("/update")
    public List<Firestation> updateFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.update(firestation);

        logger.info("Request = " + firestation );
        logger.info("HTTP PUT request received, SUCCESS / Response = " + response.toString());
        return response;
    }

    @DeleteMapping("/delete")
    public List<Firestation> deleteFireStation(@RequestParam String address) {
        List<Firestation> response = firestationService.delete(address);

        logger.info("Request = " + address);
        logger.info("HTTP DELETE request received, SUCCESS / Response = " + response.toString());
        return response;
    }

    @GetMapping("")
    public List getPersonsCoverageStation(@RequestParam String stationNumber) {
        List<StationCoverage> response = firestationService.getPersonsCoverageByStationNumber(stationNumber);
        List<String> error = new ArrayList<>();
        error.add("The request '" + stationNumber + "' doesn't match anything or is incorrect");

        logger.info("Request = /firestation?stationNumber=" + stationNumber );
        // If the response list is empty, it means that the request is correct but the parameter doesn't match with anything the json file
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response =" + response.toString());
            return response;
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
            return error;
        }

    }
}