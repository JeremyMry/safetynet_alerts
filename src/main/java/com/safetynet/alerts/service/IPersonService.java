package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;

import java.util.List;

public interface IPersonService {

    List<Person> add(Person person);

    List<Person> update(Person person);

    List<Person> delete(String firstName, String lastName);
}
