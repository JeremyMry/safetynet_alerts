package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityEmailService {

    @Autowired
    private DataContainer dataContainer;


    public CommunityEmailService(DataContainer dc) {
        this.dataContainer = dc;
    }


    public List<String> getEmailsByCityName(String city) throws Exception {
        if(city == null || city.isEmpty()) {
            throw new Exception("city is empty or null");
        }
        List <Person> listPersons = dataContainer.getPersons();
        List <String> listEmails = new ArrayList<>();
        for (Person person : listPersons) {
            if(person.getCity().equalsIgnoreCase(city) && !listEmails.contains(person.getEmail())) {
                String email = person.getEmail();
                listEmails.add(email);
            }
        }
        // return distinct emails
        return listEmails;
    }

}