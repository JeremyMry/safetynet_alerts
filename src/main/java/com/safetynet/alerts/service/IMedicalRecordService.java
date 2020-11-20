package com.safetynet.alerts.service;

import com.safetynet.alerts.model.MedicalRecord;

import java.util.List;

public interface IMedicalRecordService {

    List<MedicalRecord> add(MedicalRecord medicalrecord);

    List<MedicalRecord> update(MedicalRecord medicalrecord);

    List<MedicalRecord> delete(String firstName, String lastName);

    int getAge(String firstname, String lastName);

    String[] getMedications(String firstName, String lastName);

    String[] getAllergies(String firstName, String lastName);
}
