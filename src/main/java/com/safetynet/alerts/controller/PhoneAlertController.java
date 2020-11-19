package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.PhoneAlert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PhoneAlertController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PhoneAlert phoneAlert;

    @GetMapping("/phoneAlert")
    public List<String> getPhoneNumbersCoverageStation(@RequestParam String firestation) {
        logger.info("reee");
        return phoneAlert.getPhoneNumberByCoverage(firestation);
    }

}
