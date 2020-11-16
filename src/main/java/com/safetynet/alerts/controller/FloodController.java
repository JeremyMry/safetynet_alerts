package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.FireAlert;
import com.safetynet.alerts.service.FloodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class FloodController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FloodService floodService;

    @GetMapping("/flood/stations")
    public List<FireAlert> getHearthByStationAddress(@RequestParam String stations) {
        logger.info("eee");
        return floodService.getHearthByStationAddress(stations);
    }
}
