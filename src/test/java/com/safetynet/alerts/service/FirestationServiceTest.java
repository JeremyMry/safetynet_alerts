package com.safetynet.alerts.service;

import com.safetynet.alerts.model.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FirestationServiceTest {

    private static FirestationService firestationService;

    private static MedicalRecordService medicalRecordService;

    private static DataContainer dataContainer;

    @BeforeAll
    private static void setUp() {
        dataContainer = mock(DataContainer.class);
        medicalRecordService = new MedicalRecordService(dataContainer);
        firestationService = new FirestationService(dataContainer, medicalRecordService);
    }

    // test the add method from FirestationService class
    // it must add a firestation to the Firestation List then return this list with the new firestation added
    @Test
    public void testAdd () {
        List<Firestation> firestationList = new ArrayList<>();

        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");

        firestationList.add(firestation);

        Firestation newFirestation = new Firestation();
        newFirestation.setAddress("1509 Culver St");
        newFirestation.setStation("1");

        when(dataContainer.getFirestations()).thenReturn(firestationList);
        firestationList = firestationService.add(newFirestation);

        assertEquals(2, firestationList.size());
        assertEquals(newFirestation.getAddress(), firestationList.get(1).getAddress());
    }

    // test the update method from FirestationService class
    // it must update a firestation from the Firestation List then return this list with the updated firestation
    @Test
    public void testUpdate () {
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        firestationList.add(firestation);

        Firestation updatedFirestation = new Firestation();
        updatedFirestation.setAddress("1509 Culver St");
        updatedFirestation.setStation("1");

        List<Firestation> firestationList1 = new ArrayList<>();
        Firestation firestation1 = new Firestation();
        firestation1.setAddress("1509 Culver St");
        firestation1.setStation("1");
        firestationList1.add(firestation1);

        when(dataContainer.getFirestations()).thenReturn(firestationList1);
        firestationList = firestationService.update(updatedFirestation);

        assertEquals(1, firestationList1.size());
        assertEquals(firestationList.toString(), firestationList1.toString());
        assertEquals("1", firestationList1.get(0).getStation());
    }

    // test the delete method from FirestationService class
    // it must delete a firestation from the Firestation List then return this list without the firestation deleted
    @Test
    public void testDelete () throws Exception {
        List<Firestation> firestationList = new ArrayList<>();
        List<Firestation> firestationList1 = new ArrayList<>();

        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");

        firestationList.add(firestation);

        when(dataContainer.getFirestations()).thenReturn(firestationList);
        firestationList = firestationService.delete(firestation.getAddress());

        assertEquals(firestationList1.toString(), firestationList.toString());
    }

    // test the getPeoplesCoverageStation method from the FirestationService class
    // it must return a List of Station Coverage
    @Test
    public void getPeoplesCoverageStationTest() {
        List<Person> personList = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        person1.setPhone("841-874-6512");
        personList.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Jacob");
        person2.setLastName("Boyd");
        person2.setAddress("1509 Culver St");
        person2.setPhone("841-874-6513");
        personList.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Tenley");
        person3.setLastName("Boyd");
        person3.setAddress("1509 Culver St");
        person3.setPhone("841-874-6512");
        personList.add(person3);

        Person person4 = new Person();
        person4.setFirstName("Roger");
        person4.setLastName("Boyd");
        person4.setAddress("1509 Culver St");
        person4.setPhone("841-874-6512");
        personList.add(person4);

        List<Firestation> listFirestation = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        listFirestation.add(firestation);

        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);

        MedicalRecord medicalRecord1 = new MedicalRecord();
        medicalRecord1.setFirstName("Jacob");
        medicalRecord1.setLastName("Boyd");
        medicalRecord1.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord1);

        MedicalRecord medicalRecord2 = new MedicalRecord();
        medicalRecord2.setFirstName("Tenley");
        medicalRecord2.setLastName("Boyd");
        medicalRecord2.setBirthdate("02/18/2012");
        medicalRecordList.add(medicalRecord2);

        MedicalRecord medicalRecord3 = new MedicalRecord();
        medicalRecord3.setFirstName("Roger");
        medicalRecord3.setLastName("Boyd");
        medicalRecord3.setBirthdate("09/06/2017");
        medicalRecordList.add(medicalRecord3);

        List<PersonCovered> personCoveredList = new ArrayList<>();

        PersonCovered personCovered = new PersonCovered();
        personCovered.setFirstName("John");
        personCovered.setLastName("Boyd");
        personCovered.setAddress("1509 Culver St");
        personCovered.setPhone("841-874-6512");
        personCoveredList.add(personCovered);

        PersonCovered personCovered1 = new PersonCovered();
        personCovered1.setFirstName("Jacob");
        personCovered1.setLastName("Boyd");
        personCovered1.setAddress("1509 Culver St");
        personCovered1.setPhone("841-874-6513");
        personCoveredList.add(personCovered1);

        PersonCovered personCovered2 = new PersonCovered();
        personCovered2.setFirstName("Tenley");
        personCovered2.setLastName("Boyd");
        personCovered2.setAddress("1509 Culver St");
        personCovered2.setPhone("841-874-6512");
        personCoveredList.add(personCovered2);

        PersonCovered personCovered3= new PersonCovered();
        personCovered3.setFirstName("Roger");
        personCovered3.setLastName("Boyd");
        personCovered3.setAddress("1509 Culver St");
        personCovered3.setPhone("841-874-6512");
        personCoveredList.add(personCovered3);

        StationCoverage test = new StationCoverage(2, 2, personCoveredList);
        List<StationCoverage> stationCoverageList = new ArrayList<>();
        stationCoverageList.add(test);

        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getFirestations()).thenReturn(listFirestation);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(firestationService.getPersonsCoverageByStationNumber("3"));
        Assert.assertEquals(stationCoverageList.toString(), firestationService.getPersonsCoverageByStationNumber("3").toString());
    }

    // test the getPeoplesCoverageStation method from the FirestationService class when the station number doesn't match anything
    // it must return an empty List of Station Coverage
    @Test
    public void getPeoplesCoverageStationTestWithNoDataTest() {
        List<Person> personList = new ArrayList<>();
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        List<PersonCovered> personCoveredList = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation("000", "3");
        firestationList.add(firestation);
        List<StationCoverage> stationCoverageList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getFirestations()).thenReturn(firestationList);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(firestationService.getPersonsCoverageByStationNumber("2"));
        Assert.assertEquals(stationCoverageList.toString(), firestationService.getPersonsCoverageByStationNumber("2").toString());
    }

    // test the getPeoplesCoverageStation method from the FirestationService class when the station number is incorrect
    // it must return an empty List of Station Coverage
    @Test
    public void getPeoplesCoverageStationTestWithIncorrectParamTest() {
        List<Person> personList = new ArrayList<>();
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        List<PersonCovered> personCoveredList = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();
        List<StationCoverage> stationCoverageList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getFirestations()).thenReturn(firestationList);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(firestationService.getPersonsCoverageByStationNumber(""));
        Assert.assertEquals(stationCoverageList.toString(), firestationService.getPersonsCoverageByStationNumber("").toString());
    }

    // test the getFirestationStationNumberByAddress method from the FirestationService class
    // it must return a List of Firestation number
    @Test
    public void getFirestationStationNumberByAddressTest() {
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        firestationList.add(firestation);
        List<String> actual = new ArrayList<>();
        actual.add("3");

        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(firestationService.getFireStationStationNumberByAddress("1509 Culver St"));
        Assert.assertEquals(1, firestationService.getFireStationStationNumberByAddress("1509 Culver St").size());
        Assert.assertEquals(actual.toString(), firestationService.getFireStationStationNumberByAddress("1509 Culver St").toString());
    }

    // test the getFirestationStationNumberByAddress method from the FirestationService class when the station doesn't match with anything
    // it must return an empty List of Firestation number
    @Test
    public void getFirestationStationNumberByAddressWithIncorrectNoDataTest() {
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        firestationList.add(firestation);
        List<String> actual = new ArrayList<>();

        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(firestationService.getFireStationStationNumberByAddress("2"));
        Assert.assertEquals(actual.toString(), firestationService.getFireStationStationNumberByAddress("2").toString());
    }

    // test the getFirestationStationNumberByAddress method from the FirestationService class when the station is incorrect
    // it must return an empty List of Firestation number
    @Test
    public void getFirestationStationNumberByAddressWithIncorrectParamTest() {
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        firestationList.add(firestation);
        List<String> actual = new ArrayList<>();

        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(firestationService.getFireStationStationNumberByAddress(""));
        Assert.assertEquals(actual.toString(), firestationService.getFireStationStationNumberByAddress("").toString());
    }

    // test the getFirestationAddressByStationNumber method from the FirestationService class
    // it must return a List of Firestation address
    @Test
    public void getFirestationAddressByStationNumberTest() {
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        firestationList.add(firestation);
        List<String> actual = new ArrayList<>();
        actual.add("1509 Culver St");

        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(firestationService.getFireStationAddressByStationNumber("3"));
        Assert.assertEquals(1, firestationService.getFireStationAddressByStationNumber("3").size());
        Assert.assertEquals(actual.toString(), firestationService.getFireStationAddressByStationNumber("3").toString());
    }

    // test the getFirestationAddressByStationNumber method from the FirestationService class when the station number doesn't match with anything
    // it must return an empty List of Firestation address
    @Test
    public void getFirestationAddressByStationNumberWithNoDataTest() {
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("2");
        firestationList.add(firestation);
        List<String> actual = new ArrayList<>();

        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(firestationService.getFireStationAddressByStationNumber("3"));
        Assert.assertEquals(actual.toString(), firestationService.getFireStationAddressByStationNumber("3").toString());
    }

    // test the getFirestationAddressByStationNumber method from the FirestationService class when the station is incorrect
    // it must return an empty List of Firestation address
    @Test
    public void getFirestationAddressByStationNumberWithIncorrectParamTest() {
        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        firestationList.add(firestation);

        List<String> actual = new ArrayList<>();

        when(dataContainer.getFirestations()).thenReturn(firestationList);

        Assert.assertNotNull(firestationService.getFireStationAddressByStationNumber(""));
        Assert.assertEquals(actual.toString(), firestationService.getFireStationAddressByStationNumber("").toString());
    }
}
