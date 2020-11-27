package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordService implements IMedicalRecordService {

    @Autowired
    DataContainer dataContainer;

    public MedicalRecordService(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    // add a MedicalRecord to the medicalRecord List
    @Override
    public List<MedicalRecord> add(MedicalRecord medicalRecord) {
        List<MedicalRecord> medicalRecordsList = dataContainer.getMedicalrecords();
        medicalRecordsList.add(medicalRecord);
        return medicalRecordsList;

    }

    // update a MedicalRecord from the MedicalRecord List
    @Override
    public List<MedicalRecord> update(MedicalRecord medicalRecord) {
        String firstName = medicalRecord.getFirstName();
        String lastName = medicalRecord.getLastName();

        List<MedicalRecord> medicalRecordsList = dataContainer.getMedicalrecords();

        for (MedicalRecord mr : medicalRecordsList) {
            if (mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                mr.setBirthdate(medicalRecord.getBirthdate());
                mr.setMedications(medicalRecord.getMedications());
                mr.setAllergies(medicalRecord.getAllergies());
            }
        }
        return medicalRecordsList;

    }

    // delete a MedicalRecord from the MedicalRecord List
    @Override
    public List<MedicalRecord> delete(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordsList = dataContainer.getMedicalrecords();

        medicalRecordsList.removeIf(mr -> mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName));
        return medicalRecordsList;
    }

    // get the age of Person using her birthdate
    @Override
    public int getAge(String firstname, String lastName) {
        int age = 0;
        List<MedicalRecord> medicalRecordList = dataContainer.getMedicalrecords();
        for (MedicalRecord mr : medicalRecordList) {
            if (mr.getFirstName().equals(firstname) && mr.getLastName().equals(lastName)) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate birthdate = LocalDate.parse(mr.getBirthdate(), formatter);
                age = Period.between(birthdate, LocalDate.now()).getYears();
            }
        }
        return age;
    }

    // get the medications of a specific person
    @Override
    public List<String> getMedications(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordList = dataContainer.getMedicalrecords();
        List<String>  medications = new ArrayList<>();

        for(MedicalRecord mr: medicalRecordList) {
            if(mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                medications = mr.getMedications();
            }
        }
        return medications;
    }

    // get the allergies of a specific person
    @Override
    public List<String> getAllergies(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordList = dataContainer.getMedicalrecords();
        List<String> allergies = new ArrayList<>();

        for(MedicalRecord mr: medicalRecordList) {
            if(mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                allergies = mr.getAllergies();
            }
        }
        return allergies;
    }
}
