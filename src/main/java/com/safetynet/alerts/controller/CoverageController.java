package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.CoverageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.List;

@RestController
public class CoverageController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CoverageService coverageService;

    @GetMapping("/firestation")
    public StationCoverage getPeoplesCoverageStation(@RequestParam String stationNumber) throws ParseException {
        logger.info("eee");
        return coverageService.getPeoplesCoverageStation(stationNumber);
    }

    @GetMapping("/phoneAlert")
    public List<String> getPhoneNumbersCoverageStation(@RequestParam String firestation_number) {
        logger.info("reee");
        return coverageService.getPhoneNumberByCoverage(firestation_number);
    }

}
