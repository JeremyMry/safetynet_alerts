package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Flood;
import com.safetynet.alerts.model.Household;
import com.safetynet.alerts.service.FloodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class FloodController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FloodService floodService;

    @GetMapping("/flood/stations")
    public List<Household> getHearthByStationAddress(@RequestParam String stations) {
        List<Household> empty = new ArrayList<>();

        logger.info("Request = " + stations );
        if(!floodService.getHearthByStationAddress(stations).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return floodService.getHearthByStationAddress(stations);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}
