package com.safetynet.alerts.service;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ChildAlertService implements IChildAlertservice {

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public ChildAlertService(DataContainer dataContainer, MedicalRecordService medicalRecordService) {
        this.dataContainer = dataContainer;
        this.medicalRecordService = medicalRecordService;
    }

    // get all the child living at the address in parameter
    @Override
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
