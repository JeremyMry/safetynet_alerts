package com.safetynet.alerts.controller.crud;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.service.crud.MedicalRecordService;
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
    private MedicalRecordService medicalRecordService;


    @PostMapping("/add")
    public List<MedicalRecord> addMedicalrecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("zzz");
        return medicalRecordService.add(medicalRecord);
    }

    @PutMapping("/update")
    public List<MedicalRecord> updateMedicalrecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("zzz");
        return medicalRecordService.update(medicalRecord);

    }

    @DeleteMapping("/delete")
    public List<MedicalRecord> deleteMedicalrecord(@RequestParam String firstName, @RequestParam String lastName) {
        logger.info("zzz");
        return medicalRecordService.delete(firstName, lastName);
    }
}
