package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.Person;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PhoneAlertServiceTest {

    private static PhoneAlertService phoneAlertService;

    private static FirestationService firestationService;

    private static  MedicalRecordService medicalRecordService;

    private static DataContainer dataContainer;

    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        firestationService = new FirestationService(dataContainer, medicalRecordService);
        phoneAlertService = new PhoneAlertService(dataContainer, firestationService);
    }

    // test the getPhoneNumberByCoverage method from the PhoneAlertService class
    // it must return a List of string
    @Test
    public void getPhoneNumberListTest() {
        List<Person> listPersons = new ArrayList<>();
        Person person1 = new Person();
        person1.setAddress("1510 Culver St");
        person1.setPhone("testphone1");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setAddress("1509 Culver St");
        person2.setPhone("testphone2");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setAddress("1509 Culver St");
        person3.setPhone("testphone3");
        listPersons.add(person3);

        Person person4 = new Person();
        person4.setAddress("1509 Culver St");
        person4.setPhone("testphone4");
        listPersons.add(person4);

        Person person5 = new Person();
        person5.setAddress("1509 Culver St");
        person5.setPhone("testphone5");
        listPersons.add(person5);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);

        List<String> phoneList = new ArrayList<>();
        phoneList.add("testphone1");
        phoneList.add("testphone2");
        phoneList.add("testphone3");
        phoneList.add("testphone4");
        phoneList.add("testphone5");

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(phoneAlertService.getPhoneNumberByCoverage("2"));
        Assert.assertEquals(phoneList.toString(), phoneAlertService.getPhoneNumberByCoverage("2").toString());
    }

    // test the getPhoneNumberByCoverage method from the PhoneAlertService class when the parameters doesn't match with anything
    // it must return an empty List of string
    @Test
    public void getPhoneNumberListWithNoDataTest() {
        List<Person> listPersons = new ArrayList<>();
        List<String> phoneList = new ArrayList<>();

        Person person1 = new Person();
        person1.setAddress("1510 Culver St");
        person1.setPhone("testphone1");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setAddress("1509 Culver St");
        person2.setPhone("testphone2");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setAddress("1509 Culver St");
        person3.setPhone("testphone3");
        listPersons.add(person3);

        Person person4 = new Person();
        person4.setAddress("1509 Culver St");
        person4.setPhone("testphone4");
        listPersons.add(person4);

        Person person5 = new Person();
        person5.setAddress("1509 Culver St");
        person5.setPhone("testphone5");
        listPersons.add(person5);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);
        firestationList.add(firestation);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(phoneAlertService.getPhoneNumberByCoverage("1"));
        Assert.assertEquals(phoneList.toString(), phoneAlertService.getPhoneNumberByCoverage("1").toString());
    }

    // test the getPhoneNumberByCoverage method from the PhoneAlertService class when the parameters are incorrect
    // it must return an empty List of string
    @Test
    public void getPhoneNumberListWithIncorrectParamTest() {
        List<Person> listPersons = new ArrayList<>();
        List<String> phoneList = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();

        Person person1 = new Person();
        person1.setAddress("1510 Culver St");
        person1.setPhone("testphone1");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setAddress("1509 Culver St");
        person2.setPhone("testphone2");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setAddress("1509 Culver St");
        person3.setPhone("testphone3");
        listPersons.add(person3);

        Person person4 = new Person();
        person4.setAddress("1509 Culver St");
        person4.setPhone("testphone4");
        listPersons.add(person4);

        Person person5 = new Person();
        person5.setAddress("1509 Culver St");
        person5.setPhone("testphone5");
        listPersons.add(person5);

        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);
        firestationList.add(firestation);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(phoneAlertService.getPhoneNumberByCoverage(""));
        Assert.assertEquals(phoneList.toString(), phoneAlertService.getPhoneNumberByCoverage("").toString());
    }

}
