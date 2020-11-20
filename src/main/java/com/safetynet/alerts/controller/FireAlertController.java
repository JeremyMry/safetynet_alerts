package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.FireAlert;
import com.safetynet.alerts.service.FireAlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FireAlertController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FireAlertService fireAlertService;

    @GetMapping("/fire")
    public List<FireAlert> getPersonsByAddress(@RequestParam String address) {

        List<FireAlert> empty = new ArrayList<>();

        logger.info("Request = " + address );
        if(!fireAlertService.getPersonsByAddress(address).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return fireAlertService.getPersonsByAddress(address);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}
