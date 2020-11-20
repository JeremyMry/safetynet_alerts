package com.safetynet.alerts.service;

import com.safetynet.alerts.model.*;
import com.safetynet.alerts.service.ChildAlertService;
import com.safetynet.alerts.service.FireAlertService;
import com.safetynet.alerts.service.FirestationService;
import com.safetynet.alerts.service.MedicalRecordService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FireAlertServiceTest {

    private static FireAlertService fireAlertService;

    private static DataContainer dataContainer;

    private static FirestationService firestationService;

    private static MedicalRecordService medicalRecordService;

    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        medicalRecordService = new MedicalRecordService(dataContainer);
        firestationService = new FirestationService(dataContainer, medicalRecordService);
        fireAlertService = new FireAlertService(dataContainer, medicalRecordService, firestationService);
    }

    @Test
    public void getFireAlertWith5Persons() {

        List<Person> listPersons = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        person1.setPhone("test");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Jacob");
        person2.setLastName("Boyd");
        person2.setAddress("1509 Culver St");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Tenley");
        person3.setLastName("Boyd");
        person3.setAddress("1509 Culver St");
        listPersons.add(person3);

        Person person4 = new Person();
        person4.setFirstName("Roger");
        person4.setLastName("Boyd");
        person4.setAddress("1509 Culver St");
        listPersons.add(person4);

        Person person5 = new Person();
        person5.setFirstName("Felicia");
        person5.setLastName("Boyd");
        person5.setAddress("1509 Culver St");
        listPersons.add(person5);

        when(dataContainer.getPersons()).thenReturn(listPersons);

        Assert.assertNotNull(fireAlertService.getPersonsByAddress("1509 Culver St"));
        Assert.assertEquals(5, fireAlertService.getPersonsByAddress("1509 Culver St").size());
    }

    @Test
    public void getFireAlertWithDifferentAddresses() {

        List<Person> listPersons = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        person1.setPhone("test");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Jacob");
        person2.setLastName("Boyd");
        person2.setAddress("1509 Culver St");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Tenley");
        person3.setLastName("Boyd");
        person3.setAddress("1510 Culver St");
        listPersons.add(person3);

        when(dataContainer.getPersons()).thenReturn(listPersons);

        Assert.assertNotNull(fireAlertService.getPersonsByAddress("1509 Culver St"));
        Assert.assertEquals(2, fireAlertService.getPersonsByAddress("1509 Culver St").size());
    }

    @Test
    public void getFireAlertWithNoData() {
        List<Person> listPersons = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);

        Assert.assertNotNull(fireAlertService.getPersonsByAddress("1509 Culver St"));
        Assert.assertEquals(0, fireAlertService.getPersonsByAddress("1509 Culver St").size());
    }

    @Test
    public void getFireAlertWithNoAddress() {
        List<Person> listPersons = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);

        Assert.assertNotNull(fireAlertService.getPersonsByAddress(null));
        Assert.assertEquals(0, fireAlertService.getPersonsByAddress(null).size());
    }
}
