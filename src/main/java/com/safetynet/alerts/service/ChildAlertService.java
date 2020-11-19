package com.safetynet.alerts.service;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
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

    public List<ChildAlert> getChildByAddress(String address) {
        List<Person> personList = dataContainer.getPersons();
        List<String> family = new ArrayList<>();
        List<ChildAlert> childAlertList = new ArrayList<>();

        for(Person person: personList) {
            if(person.getAddress().equals(address)) {
                int age = medicalRecordService.getAge(person.getFirstName(), person.getLastName());
                if(age <= 18) {
                    ChildAlert childAlert = new ChildAlert();
                    childAlert.setFirstName(person.getFirstName());
                    childAlert.setLastName(person.getLastName());
                    childAlert.setAge(age);
                    childAlert.setFamily(family);
                    childAlertList.add(childAlert);
                } else {
                    String fusion = person.getFirstName() + " " + person.getLastName();
                    family.add(fusion);
                }
            }
        }
        return childAlertList;
    }
}
