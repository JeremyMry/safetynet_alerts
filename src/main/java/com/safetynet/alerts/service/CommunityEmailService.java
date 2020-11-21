package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityEmailService implements ICommunityEmailService {

    @Autowired
    private DataContainer dataContainer;

    public CommunityEmailService(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Override
    public List<String> getEmailByCity(String city) {
        List<Person> personList = dataContainer.getPersons();
        List<String> emailList = new ArrayList<>();

        for(Person person: personList) {
            if (person.getCity().equals(city)) {
                emailList.add(person.getEmail());
            }
        }
        return emailList;
    }
}
