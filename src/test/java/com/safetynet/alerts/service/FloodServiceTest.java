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

public class FloodServiceTest {

    private static FloodService floodService;

    private static DataContainer dataContainer;

    private static FirestationService firestationService;

    private static MedicalRecordService medicalRecordService;

    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        medicalRecordService = new MedicalRecordService(dataContainer);
        firestationService = new FirestationService(dataContainer, medicalRecordService);
        floodService = new FloodService(dataContainer, medicalRecordService, firestationService);
    }

    @Test
    public void getFloodWithOneAddress() {
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

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(floodService.getHouseholdByStationAddress("2"));
        Assert.assertEquals(1, floodService.getHouseholdByStationAddress("2").size());
    }

    @Test
    public void getFloodWithTwoAddress() {
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
        person2.setAddress("1510 Culver St");
        listPersons.add(person2);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(floodService.getHouseholdByStationAddress("2"));
        Assert.assertEquals(2, floodService.getHouseholdByStationAddress("2").size());
    }

    @Test
    public void getFloodWithNoData() {
        List<Person> listPersons = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(floodService.getHouseholdByStationAddress("2"));
        Assert.assertEquals(0, floodService.getHouseholdByStationAddress("2").size());
    }

    @Test
    public void getFloodWithNoStationNumber() {
        List<Person> listPersons = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(floodService.getHouseholdByStationAddress(null));
        Assert.assertEquals(0, floodService.getHouseholdByStationAddress(null).size());
    }

}
