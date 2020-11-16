package com.safetynet.alerts.service;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.crud.MedicalRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChildAlertService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public ChildAlert getChildByAddress(String address) {
        List<Person> personList = dataContainer.getPersons();
        ChildAlert childAlert = new ChildAlert();
        List<String> family = new ArrayList<>();

        for(Person person: personList) {
            if(person.getAddress().equals(address)) {
                int age = medicalRecordService.getAge(person.getFirstName(), person.getLastName());
                if(age <= 18) {
                    childAlert.setFirstName(person.getFirstName());
                    childAlert.setLastName(person.getLastName());
                    childAlert.setAge(age);
                } else {
                    String fusion = person.getFirstName() + " " + person.getLastName();
                    family.add(fusion);
                }
            }
        }
        childAlert.setFamily(family);
        return childAlert;
    }
}
