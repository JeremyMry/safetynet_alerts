package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirestationsController {

    @Autowired
    private DataContainer dataContainer;

    @Autowired
    private FirestationService firestationService;

    @GetMapping("/firestation")
    public List<Firestation> getAllFirestations() {
    return dataContainer.getFirestations();
    }
}