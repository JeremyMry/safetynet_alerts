package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.crud.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoverageService {

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public StationCoverage getPeoplesCoverageStation(String stationNumber) throws ParseException {
        List<Person> personList = dataContainer.getPersons();
        List<Person> personsCovered = new ArrayList<>();
        int adult = 0;
        int child = 0;

        for( Person person : personList) {
            if(getFirestationAddressByStationNumber(stationNumber).contains(person.getAddress())) {
                Person personCovered = new Person();
                personCovered.setFirstName(person.getFirstName());
                personCovered.setLastName(person.getLastName());
                personCovered.setAddress(person.getAddress());
                personCovered.setPhone(person.getPhone());
                personsCovered.add(personCovered);
                if (medicalRecordService.getAge(personCovered.getFirstName(), personCovered.getLastName()) <= 18) {
                    child++;
                } else {
                    adult++;
                }
            }
        }
        return new StationCoverage(adult, child, personsCovered);
    }

    public List<String> getPhoneNumberByCoverage(String firestation_number) {
        List<Person> personList = dataContainer.getPersons();
        List<String> phoneNumberList = new ArrayList<>();

        for(Person person : personList) {
            if(getFirestationAddressByStationNumber(firestation_number).contains(person.getAddress())) {
                phoneNumberList.add(person.getPhone());
            }
        }
        return phoneNumberList;
    }

    public List<String> getFirestationAddressByStationNumber(String stationNumber) {
        List<Firestation> firestationList = dataContainer.getFirestations();
        List<String> firestationAddress = new ArrayList<>();

        for (Firestation fs : firestationList) {
            if (fs.getStation().equals(stationNumber)) {
                String address = fs.getAddress();
                firestationAddress.add(address);
            }
        }
        return firestationAddress;
    }
}
