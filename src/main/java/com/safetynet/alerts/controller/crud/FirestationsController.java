package com.safetynet.alerts.controller.crud;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.StationNumber;
import com.safetynet.alerts.service.crud.FirestationService;
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

    @GetMapping("")
    public StationNumber getPeoplesCoverageStation(@RequestParam String stationNumber) throws ParseException {
        logger.info("eee");
        return firestationService.getPeoplesCoverageStation(stationNumber);
    }

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
    public List<Firestation> deleteFirestation(@RequestBody Firestation firestation) {
        logger.info("eee");
        return firestationService.delete(firestation);
    }
}