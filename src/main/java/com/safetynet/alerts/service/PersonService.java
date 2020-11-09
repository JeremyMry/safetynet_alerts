package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private DataContainer dataContainer;

    public PersonService(DataContainer dc) {
        this.dataContainer = dc;
    }


    public List<Person> update(Person person) {
        String firstname = person.getFirstName();
        String lastName = person.getLastName();

        List<Person> listPersons = dataContainer.getPersons();

        for (Person p : listPersons) {
            // suppose that firstname and lastname can not changed
            if (p.getFirstName().equals(firstname) && p.getLastName().equals(lastName)) {
                p.setAddress(person.getAddress());
                p.setCity(person.getCity());
                p.setZip(person.getZip());
                p.setPhone(person.getPhone());
                p.setEmail(person.getEmail());
            }
        }
        return listPersons;

    }

    public List<Person> add(Person person) {
        List<Person> listPersons = dataContainer.getPersons();
        listPersons.add(person);
        return listPersons;

    }

    public List<Person> delete(String firstName, String lastName) {
        List<Person> listPersons = dataContainer.getPersons();
        Iterator<Person> it = listPersons.iterator();

        while (it.hasNext()) {
            Person person = it.next();
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                it.remove();
            }

        }
        return listPersons;
    }
}
