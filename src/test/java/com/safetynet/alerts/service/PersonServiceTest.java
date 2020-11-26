package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    private static PersonService personService;

    private static DataContainer dataContainer;

    @BeforeAll
    private static void setUp() {
        dataContainer = mock(DataContainer.class);
        personService = new PersonService(dataContainer);
    }

    // test the add method from PersonService class
    // it must add a Person to the List of Person and then return the List of Person with the new Person added
    @Test
    public void addTest() throws Exception {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setZip("97451");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");

        personList.add(person);


        Person newPerson = new Person();
        newPerson.setFirstName("John");
        newPerson.setLastName("Doe");
        newPerson.setAddress("random");
        newPerson.setCity("Random");
        newPerson.setZip("000");
        newPerson.setPhone("444-444");
        newPerson.setEmail("john.doe@testmail.com");

        when(dataContainer.getPersons()).thenReturn(personList);
        personList = personService.add(newPerson);

        assertEquals(2, personList.size());
        assertEquals(newPerson.getFirstName(), personList.get(1).getFirstName());
        assertEquals(newPerson.getLastName(), personList.get(1).getLastName());
        assertEquals(newPerson.getAddress(), personList.get(1).getAddress());
        assertEquals(newPerson.getCity(), personList.get(1).getCity());
        assertEquals(newPerson.getZip(), personList.get(1).getZip());
        assertEquals(newPerson.getPhone(), personList.get(1).getPhone());
        assertEquals(newPerson.getEmail(), personList.get(1).getEmail());
    }

    // test the update method from PersonService class
    // it must update a Person from the List of Person and then return the List of Person with the  Person updated
    @Test
    public void updateTest() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setZip("97451");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");
        personList.add(person);

        Person updatedPerson = new Person();
        updatedPerson.setFirstName("John");
        updatedPerson.setLastName("Boyd");
        updatedPerson.setEmail("jaboyd@testmail.com");

        when(dataContainer.getPersons()).thenReturn(personList);
        personService.update(updatedPerson);

        assertEquals(personList.get(0).getEmail(), personService.update(updatedPerson).get(0).getEmail());
    }

    // test the update method from PersonService class with unknown param
    // it must return the Person List with no changes
    @Test
    public void updateWithIncorrectParamTest() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setZip("97451");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");
        personList.add(person);

        Person updatedPerson = new Person();
        updatedPerson.setFirstName("John");
        updatedPerson.setLastName("Doe");
        updatedPerson.setEmail("jaboyd@email.com");

        when(dataContainer.getPersons()).thenReturn(personList);

        assertEquals(personList.toString(), personService.update(updatedPerson).toString());
    }

    // test the update method from PersonService class with unknown param
    // it must return the Person List with no changes
    @Test
    public void updateWithIncorrectParamTest2() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setZip("97451");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");
        personList.add(person);

        Person updatedPerson = new Person();
        updatedPerson.setFirstName("Paul");
        updatedPerson.setLastName("Boyd");
        updatedPerson.setEmail("jaboyd@email.com");

        when(dataContainer.getPersons()).thenReturn(personList);

        assertEquals(personList.toString(), personService.update(updatedPerson).toString());
    }

    // test the delete method from PersonService class
    // it must delete a Person from the List of Person and then return the List of Person without the  Person deleted
    @Test
    public void testDelete() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setZip("97451");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");
        personList.add(person);

        when(dataContainer.getPersons()).thenReturn(personList);

        assertEquals(0, personService.delete(person.getFirstName(), person.getLastName()).size());
    }

    // test the delete method from PersonService class with unknown param
    // it must return the Person List with no changes
    @Test
    public void deleteTestWithIncorrectParamTest()  {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setZip("97451");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");
        personList.add(person);

        when(dataContainer.getPersons()).thenReturn(personList);

        assertEquals(personList.toString(), personService.delete("ee", "Boyd").toString());
    }

    // test the delete method from PersonService class with unknown param
    // it must return the Person List with no changes
    @Test
    public void deleteTestWithIncorrectParamTest2()  {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setCity("Culver");
        person.setZip("97451");
        person.setPhone("841-874-6512");
        person.setEmail("jaboyd@email.com");
        personList.add(person);

        when(dataContainer.getPersons()).thenReturn(personList);

        assertEquals(personList.toString(), personService.delete("John", "ee").toString());
    }
}
