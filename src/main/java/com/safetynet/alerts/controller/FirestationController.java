package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.FirestationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FirestationService firestationService;

    @PostMapping("/add")
    public List<Firestation> addFireStation(@RequestBody Firestation firestation) {
        List<Firestation> empty = new ArrayList<>();

        logger.info("Request = " + firestation );
        if(!firestationService.add(firestation).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return firestationService.add(firestation);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }

    @PutMapping("/update")
    public List<Firestation> updateFireStation(@RequestBody Firestation firestation) {
        List<Firestation> empty = new ArrayList<>();

        logger.info("Request = " + firestation );
        if(!firestationService.update(firestation).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return firestationService.update(firestation);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }

    @DeleteMapping("/delete")
    public List<Firestation> deleteFireStation(@RequestParam String address) {
        List<Firestation> empty = new ArrayList<>();

        logger.info("Request = " + address );
        if(!firestationService.delete(address).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return firestationService.delete(address);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }

    @GetMapping("")
    public StationCoverage getPersonsCoverageStation(@RequestParam String stationNumber) {
        StationCoverage empty = new StationCoverage();

        logger.info("Request = " + stationNumber );
        Optional<StationCoverage> fireStationOptional = Optional.ofNullable(firestationService.getPersonsCoverageByStationNumber(stationNumber));
        if(fireStationOptional.isPresent()) {
            logger.info("HTTP GET request received, SUCCESS");
            return firestationService.getPersonsCoverageByStationNumber(stationNumber);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}