package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.CommunityEmailService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommunityEmailController {

    private final Logger logger;

    public CommunityEmailController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    private CommunityEmailService communityEmailService;

    @GetMapping("/communityEmail")
    public List<String> getEmailsByCity(@RequestParam String city) {
        List<String> response = communityEmailService.getEmailByCity(city);

        logger.info("Request = " + city );
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
        }
        return response;
    }
}
