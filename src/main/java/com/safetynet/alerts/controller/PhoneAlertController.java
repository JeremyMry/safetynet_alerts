package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.PhoneAlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhoneAlertController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PhoneAlertService phoneAlertService;

    @GetMapping("/phoneAlert")
    public List<String> getPhoneNumbersByCoverageStation(@RequestParam String firestation) {
        List<String> empty = new ArrayList<>();

        logger.info("Request = " + firestation );
        if(!phoneAlertService.getPhoneNumberByCoverage(firestation).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return phoneAlertService.getPhoneNumberByCoverage(firestation);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }

}
