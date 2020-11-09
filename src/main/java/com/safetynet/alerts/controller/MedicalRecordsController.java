package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordsController {

    @Autowired
    private DataContainer dataContainer;

    @Autowired
    private MedicalRecordService medicalRecordService;


    @PostMapping("/add")
    public List<MedicalRecord> addMedicalrecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> listMedicalrecord = this.medicalRecordService.add(medicalRecord);
        return listMedicalrecord;
    }

    @PutMapping("/update")
    public List<MedicalRecord> updateMedicalrecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> listMedicalrecords = medicalRecordService.update(medicalRecord);
        return listMedicalrecords;

    }

    @DeleteMapping("/delete")
    public List<MedicalRecord> deleteMedicalrecord(@RequestParam String firstName, @RequestParam String lastName) {
        List<MedicalRecord> listMedicalrecords = medicalRecordService.delete(firstName, lastName);
        return listMedicalrecords;
    }
}
