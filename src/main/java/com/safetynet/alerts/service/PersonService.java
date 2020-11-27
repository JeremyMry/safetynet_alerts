package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    DataContainer dataContainer;

    public PersonService(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    // add a Person to the Person List
    @Override
    public List<Person> add(Person person) {
        List<Person> listPersons = dataContainer.getPersons();
        listPersons.add(person);
        return listPersons;
    }

    // update a Person from the Person List
    @Override
    public List<Person> update(Person person) {
        String firstname = person.getFirstName();
        String lastName = person.getLastName();

        List<Person> listPersons = dataContainer.getPersons();

        for (Person p : listPersons) {
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

    // delete a Person from the Person List
    @Override
    public List<Person> delete(String firstName, String lastName) {
        List<Person> listPersons = dataContainer.getPersons();

        listPersons.removeIf(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName));
        return listPersons;
    }
}
