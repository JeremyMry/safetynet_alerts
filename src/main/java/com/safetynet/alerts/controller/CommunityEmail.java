package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.CommunityEmailService;
import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/communityEmail")
@RestController
public class CommunityEmail {

    @Autowired
    CommunityEmail communityEmail;

    @Autowired
    CommunityEmailService communityEmailService;

    @GetMapping("")
    public List<String> getEmailbyCity(@RequestParam String city) throws Exception {
        List<String> EmailList = communityEmailService.getEmailsByCityName(city);
        return EmailList;
    }
}
