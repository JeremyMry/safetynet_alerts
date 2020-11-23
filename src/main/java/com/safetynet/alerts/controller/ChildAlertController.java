package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.service.ChildAlertService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ChildAlertController {

    private final Logger logger;

    ChildAlertController(final Logger logger)
    {
        this.logger = logger;
    }

    @Autowired
    ChildAlertService childAlertService;

    @GetMapping("/childAlert")
    public List<ChildAlert> getChildByAddress(@RequestParam String address) {
        List<ChildAlert> response = childAlertService.getChildByAddress(address);

        logger.info("Request = /childAlert?address=" + address);
        if(!response.isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS / Response = " + response.toString());
        } else {
            logger.error("HTTP GET request received, ERROR / Response = " + response.toString());
        }
        return response;
    }
}
