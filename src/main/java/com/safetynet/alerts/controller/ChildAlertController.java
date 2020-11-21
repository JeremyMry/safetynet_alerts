package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.service.ChildAlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ChildAlertController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ChildAlertService childAlertService;

    @GetMapping("/childAlert")
    public List<ChildAlert> getChildByAddress(@RequestParam String address) {

        List<ChildAlert> empty = new ArrayList<>();

        logger.info("Request = " + address);
        if(!childAlertService.getChildByAddress(address).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return childAlertService.getChildByAddress(address);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}
