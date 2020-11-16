package com.safetynet.alerts.service;

import com.safetynet.alerts.model.*;
import com.safetynet.alerts.service.crud.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FireAlertService {

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public List<FireAlert> getPersonsByAddress(String address) {
        List<FireAlert> fireAlertList = new ArrayList<>();
        List<Person> personList = dataContainer.getPersons();

        for(Person person : personList) {
            if(person.getAddress().equals(address)) {
                FireAlert fireAlert = new FireAlert();
                fireAlert.setFirstName(person.getFirstName());
                fireAlert.setLastName(person.getLastName());
                fireAlert.setPhone(person.getPhone());
                fireAlert.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                fireAlert.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                fireAlert.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
                fireAlert.setStationNumber(getFirestationStationByAddress(address));
                fireAlertList.add(fireAlert);
            }
        }
        return fireAlertList;
    }


    public List<String> getFirestationStationByAddress(String address) {
        List<Firestation> firestationList = dataContainer.getFirestations();
        List<String> firestationAddress = new ArrayList<>();

        for (Firestation fs : firestationList) {
            if (fs.getAddress().equals(address)) {
                String station = fs.getStation();
                firestationAddress.add(station);
            }
        }
        return firestationAddress;
    }


}
