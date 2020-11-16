package com.safetynet.alerts.service.crud;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.StationNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FirestationService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataContainer dataContainer;

    @Autowired MedicalRecordService medicalRecordService;

    public StationNumber getPeoplesCoverageStation(String stationNumber) throws ParseException {
        List<Firestation> firestationList = dataContainer.getFirestations();
        List<Person> personList = dataContainer.getPersons();
        List<String> firestationAddress = new ArrayList<>();
        List<Person> personsCovered = new ArrayList<>();
        int adult = 0;
        int child = 0;

        for (Firestation fs : firestationList) {
            if (fs.getStation().equals(stationNumber)) {
                String address = fs.getAddress();
                firestationAddress.add(address);
            }
        }

        for( Person person : personList) {
            if(firestationAddress.contains(person.getAddress())) {
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
        return new StationNumber(adult, child, personsCovered);
    }


    public List<Firestation> add(Firestation firestation) {
        List<Firestation> listFirestations = dataContainer.getFirestations();
        listFirestations.add(firestation);
        logger.info("zzz");
        return listFirestations;

    }

    public List<Firestation> update(Firestation firestation) {

        String address = firestation.getAddress();
        String station = firestation.getStation();
        List<Firestation> listFirestations = dataContainer.getFirestations();

        for (Firestation fs : listFirestations) {
            if (fs.getAddress().equals(address)) {
                fs.setStation(station);
            }
        }
        logger.info("zzz");
        return listFirestations;
    }

    public List<Firestation> delete(Firestation firestation) {
        List<Firestation> listFirestations = dataContainer.getFirestations();
        Iterator<Firestation> it = listFirestations.iterator();

        String address = firestation.getAddress();

        while (it.hasNext()) {
            Firestation fs = it.next();
            if (fs.getAddress().equals(address)) {
                it.remove();
            }
        }
        logger.info("zzz");
        return listFirestations;
    }
}