package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.service.MedicalRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataContainer dataContainer;

    @Autowired
    private MedicalRecordService medicalRecordService;


    @PostMapping("/add")
    public List<MedicalRecord> addMedicalrecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> listMedicalrecord = this.medicalRecordService.add(medicalRecord);
        logger.info("zzz");
        return listMedicalrecord;
    }

    @PutMapping("/update")
    public List<MedicalRecord> updateMedicalrecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> listMedicalrecords = medicalRecordService.update(medicalRecord);
        logger.info("zzz");
        return listMedicalrecords;

    }

    @DeleteMapping("/delete")
    public List<MedicalRecord> deleteMedicalrecord(@RequestParam String firstName, @RequestParam String lastName) {
        List<MedicalRecord> listMedicalrecords = medicalRecordService.delete(firstName, lastName);
        logger.info("zzz");
        return listMedicalrecords;
    }
}
