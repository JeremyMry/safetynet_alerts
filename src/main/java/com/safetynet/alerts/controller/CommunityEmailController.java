package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.service.CommunityEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CommunityEmailController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommunityEmailService communityEmailService;

    @GetMapping("/communityEmail")
    public List<String> getEmail(@RequestParam String city) {
        logger.info("eee");
        return communityEmailService.getEmail(city);
    }
}
