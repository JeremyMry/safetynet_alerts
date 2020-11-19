package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.FirestationService;
import org.apache.tomcat.jni.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/firestation")
@RestController
public class FirestationsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FirestationService firestationService;

    @PostMapping("/add")
    public List<Firestation> addFirestation(@RequestBody Firestation firestation) {
        logger.info("eee");
        return firestationService.add(firestation);
    }

    @PutMapping("/update")
    public List<Firestation> updateFirestation(@RequestBody Firestation firestation) {
        logger.info("eee");
        return firestationService.update(firestation);
    }

    @DeleteMapping("/delete")
    public List<Firestation> deleteFirestation(@RequestParam String address) {
        logger.info("eee");
        return firestationService.delete(address);
    }

    @GetMapping("")
    public StationCoverage getPeoplesCoverageStation(@RequestParam String stationNumber) throws ParseException {
        logger.info("eee");
        return firestationService.getPeoplesCoverageStation(stationNumber);
    }
}