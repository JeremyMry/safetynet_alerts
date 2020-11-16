package com.safetynet.alerts.service.crud;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.crud.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private DataContainer dataContainer;

    public List<MedicalRecord> add(MedicalRecord medicalrecord) {
        List<MedicalRecord> listMedicalrecords = dataContainer.getMedicalrecords();
        listMedicalrecords.add(medicalrecord);
        return listMedicalrecords;

    }

    public List<MedicalRecord> update(MedicalRecord medicalrecord) {
        String firstname = medicalrecord.getFirstName();
        String lastName = medicalrecord.getLastName();

        List<MedicalRecord> listmedicalrecords = dataContainer.getMedicalrecords();

        for (MedicalRecord mr : listmedicalrecords) {
            if (mr.getFirstName().equals(firstname) && mr.getLastName().equals(lastName)) {
                mr.setBirthdate(medicalrecord.getBirthdate());
                mr.setMedications(medicalrecord.getMedications());
                mr.setAllergies(medicalrecord.getAllergies());
            }
        }
        return listmedicalrecords;

    }

    public List<MedicalRecord> delete(String firstName, String lastName) {
        List<MedicalRecord> listmedicalrecords = dataContainer.getMedicalrecords();
        Iterator<MedicalRecord> it = listmedicalrecords.iterator();

        while (it.hasNext()) {
            MedicalRecord mr = it.next();
            if (mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                it.remove();
            }

        }
        return listmedicalrecords;
    }

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

    public String[] getMedications(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordList = dataContainer.getMedicalrecords();
        String[] medications = null;

        for(MedicalRecord mr: medicalRecordList) {
            if(mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                medications = mr.getMedications();
            }
        }
        return medications;
    }

    public String[] getAllergies(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordList = dataContainer.getMedicalrecords();
        String[] allergies = null;

        for(MedicalRecord mr: medicalRecordList) {
            if(mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                allergies = mr.getAllergies();
            }
        }
        return allergies;
    }

}
