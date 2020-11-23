package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.PersonCovered;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.FirestationService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

    private final Logger logger;

    private StationCoverage stationCoverage;

    public FirestationController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    private FirestationService firestationService;

    @PostMapping("/add")
    public List<Firestation> addFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.add(firestation);

        logger.info("Request = " + firestation );
        if(!response.isEmpty()) {
            logger.info("HTTP POST request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP POST request received, ERROR / Response = " + response.toString());
        }
        return response;
    }

    @PutMapping("/update")
    public List<Firestation> updateFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.update(firestation);

        logger.info("Request = " + firestation );
        if(!response.isEmpty()) {
            logger.info("HTTP PUT request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP PUT request received, ERROR / Response = " + response.toString());
        }
        return response;
    }

    @DeleteMapping("/delete")
    public List<Firestation> deleteFireStation(@RequestParam String address) {
        List<Firestation> response = firestationService.delete(address);

        logger.info("Request = " + address);
        if(!response.isEmpty()) {
            logger.info("HTTP DELETE request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP DELETE request received, ERROR / Response = " + response.toString());
        }
        return response;
    }

    @GetMapping("")
    public StationCoverage getPersonsCoverageStation(@RequestParam String stationNumber) {
        StationCoverage response = firestationService.getPersonsCoverageByStationNumber(stationNumber);
        List<PersonCovered> personCoveredList = firestationService.getPersonsCoverageByStationNumber(stationNumber).getPersonsCovered();

        logger.info("Request = /firestation?stationNumber=" + stationNumber );
        if(!personCoveredList.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response =" + response.toString());
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
        }
        return response;
    }
}