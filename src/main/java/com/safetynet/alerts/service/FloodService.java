package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Flood;
import com.safetynet.alerts.model.crud.Person;
import com.safetynet.alerts.service.crud.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FloodService {

    @Autowired
    CoverageService coverageService;

    @Autowired
    DataContainer dataContainer;

    @Autowired
    MedicalRecordService medicalRecordService;

    public Collection<List<Flood>> getHearthByStationAddress(String stationNumber) {
        List<String> stationAddress = coverageService.getFirestationAddressByStationNumber(stationNumber);
        List<Flood> floodList = new ArrayList<>();
        List<Person> personList = dataContainer.getPersons();

        for(Person person: personList) {
            if(stationAddress.contains(person.getAddress())) {
                Flood flood = new Flood();
                flood.setFirstName(person.getFirstName());
                flood.setLastName(person.getLastName());
                flood.setPhone(person.getPhone());
                flood.setAddress(person.getAddress());
                flood.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                flood.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                flood.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
                floodList.add(flood);
            }
        }
        Collection<List<Flood>> output = floodList.stream().collect(Collectors.groupingBy(Flood::getAddress)).values();
        return output;
    }

}
