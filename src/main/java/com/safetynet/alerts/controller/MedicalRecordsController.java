package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Model;
import com.safetynet.alerts.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicalRecordsController {

    @Autowired
    private Model model;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalrecord")
    public List<MedicalRecord> getAllMedicalRecords() {
        return model.getMedicalrecords();
    }
}
