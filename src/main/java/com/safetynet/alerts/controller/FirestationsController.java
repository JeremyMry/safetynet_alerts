package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/firestation")
@RestController
public class FirestationsController {

    @Autowired
    private DataContainer dataContainer;

    @Autowired
    private FirestationService firestationService;

    @PostMapping("/add")
    public List<Firestation> addFirestation(@RequestBody Firestation firestation) {
        List<Firestation> listFirestations = this.firestationService.add(firestation);
        return listFirestations;
    }

    @PutMapping("/update")
    public List<Firestation> updateFirestation(@RequestBody Firestation firestation) {
        List<Firestation> listFirestations = firestationService.update(firestation);
        return listFirestations;
    }

    @DeleteMapping("/delete")
    public List<Firestation> deleteFirestation(@RequestBody Firestation firestation) {
        List<Firestation> listFirestations = firestationService.delete(firestation);
        return listFirestations;
    }
}