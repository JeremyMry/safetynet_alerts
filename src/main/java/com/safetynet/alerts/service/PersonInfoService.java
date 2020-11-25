package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonInfoService implements  IPersonInfoService {

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public PersonInfoService(DataContainer dataContainer, MedicalRecordService medicalRecordService) {
        this.dataContainer = dataContainer;
        this.medicalRecordService = medicalRecordService;
    }

    @Override
    public List<PersonInfo> getPersonInformation(String firstName, String lastName) {
        List<Person> personList = dataContainer.getPersons();
        List<PersonInfo> personInfoList = new ArrayList<>();

        for(Person person : personList) {
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                PersonInfo pi = new PersonInfo();
                pi.setFirstName(person.getFirstName());
                pi.setLastName(person.getLastName());
                pi.setAddress(person.getAddress());
                pi.setEmail(person.getEmail());
                pi.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                pi.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                pi.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
                personInfoList.add(pi);
            }
        }
        return personInfoList;
    }
}
