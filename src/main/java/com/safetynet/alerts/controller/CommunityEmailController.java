package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.service.CommunityEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommunityEmailController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommunityEmailService communityEmailService;

    @GetMapping("/communityEmail")
    public List<String> getEmail(@RequestParam String city) {

        List<String> empty = new ArrayList<>();

        logger.info("Request = " + city );
        if(!communityEmailService.getEmail(city).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return communityEmailService.getEmail(city);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}
