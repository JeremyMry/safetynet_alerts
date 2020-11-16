package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.crud.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonInfoService {

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public PersonInfo getPersonInformations(String firstName, String lastName) {
        List<Person> personList = dataContainer.getPersons();
        List<MedicalRecord> medicalRecordList = dataContainer.getMedicalrecords();
        PersonInfo pi = new PersonInfo();
        for(Person person : personList) {
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                pi.setFirstName(person.getFirstName());
                pi.setLastName(person.getLastName());
                pi.setAddress(person.getAddress());
                pi.setEmail(person.getEmail());
                pi.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                pi.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                pi.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
            }
        }
        return pi;
    }
}
