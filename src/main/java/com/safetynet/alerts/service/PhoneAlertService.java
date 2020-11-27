package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneAlertService implements IPhoneAlertService {

    @Autowired
    DataContainer dataContainer;

    @Autowired
    FirestationService firestationService;

    public PhoneAlertService(DataContainer dataContainer, FirestationService firestationService) {
        this.dataContainer = dataContainer;
        this.firestationService = firestationService;
    }

    // get the Phone Numbers of all the Persons covered by the station who is in parameter
    @Override
    public List<String> getPhoneNumberByCoverage(String firestation_number) {
        List<Person> personList = dataContainer.getPersons();
        List<String> phoneNumberList = new ArrayList<>();

        for(Person person : personList) {
            if(firestationService.getFireStationAddressByStationNumber(firestation_number).contains(person.getAddress())) {
                phoneNumberList.add(person.getPhone());
            }
        }
        return phoneNumberList;
    }
}
