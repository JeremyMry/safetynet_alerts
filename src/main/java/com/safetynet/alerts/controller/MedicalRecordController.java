package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MedicalRecordService medicalRecordService;


    @PostMapping("/add")
    public List<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> empty = new ArrayList<>();

        logger.info("Request = " + medicalRecord );
        if(!medicalRecordService.add(medicalRecord).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return medicalRecordService.add(medicalRecord);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }

    @PutMapping("/update")
    public List<MedicalRecord> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> empty = new ArrayList<>();

        logger.info("Request = " + medicalRecord );
        if(!medicalRecordService.update(medicalRecord).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return medicalRecordService.update(medicalRecord);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }

    }

    @DeleteMapping("/delete")
    public List<MedicalRecord> deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
        List<MedicalRecord> empty = new ArrayList<>();

        logger.info("Request = " + firstName + " " + lastName );
        if(!medicalRecordService.delete(firstName, lastName).isEmpty()) {
            logger.info("HTTP GET request received, SUCCESS");
            return medicalRecordService.delete(firstName, lastName);
        } else {
            logger.error("HTTP GET request received, ERROR");
            return empty;
        }
    }
}
