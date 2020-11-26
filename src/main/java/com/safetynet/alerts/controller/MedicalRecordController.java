package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordController {

    private final Logger logger;

    public MedicalRecordController(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    MedicalRecordService medicalRecordService;


    @PostMapping("/add")
    public List<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> response = medicalRecordService.add(medicalRecord);

        logger.info("Request = " + medicalRecord );
        logger.info("HTTP POST request received, SUCCESS / Response = " + response.toString());
        return response;
    }

    @PutMapping("/update")
    public List<MedicalRecord> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> response = medicalRecordService.update(medicalRecord);

        logger.info("Request = " + medicalRecord );
        logger.info("HTTP PUT request received, SUCCESS / Response = " + response.toString());
        return response;
    }

    @DeleteMapping("/delete")
    public List<MedicalRecord> deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
        List<MedicalRecord> response = medicalRecordService.delete(firstName, lastName);

        logger.info("Request = " + firstName + " " + lastName );
        logger.info("HTTP DELETE request received, SUCCESS / Response = " + response.toString());
        return response;
    }
}
