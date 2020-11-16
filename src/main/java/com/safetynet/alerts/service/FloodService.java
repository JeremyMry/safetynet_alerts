package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.FireAlert;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.crud.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloodService {

    @Autowired
    CoverageService coverageService;

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public List<FireAlert> getHearthByStationAddress(String stationNumber) {
        List<String> stationAddress = coverageService.getFirestationAddressByStationNumber(stationNumber);
        List<FireAlert> fireAlertList = new ArrayList<>();
        List<Person> personList = dataContainer.getPersons();

        for(Person person: personList) {
            if(stationAddress.contains(person.getAddress())) {
                FireAlert fireAlert = new FireAlert();
                fireAlert.setFirstName(person.getFirstName());
                fireAlert.setLastName(person.getLastName());
                fireAlert.setPhone(person.getPhone());
                fireAlert.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                fireAlert.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                fireAlert.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
                fireAlertList.add(fireAlert);
            }
        }
        return fireAlertList;
    }

}
