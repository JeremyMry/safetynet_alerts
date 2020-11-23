package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ModelTest {

    @Test
    public void dataContainerTest() {
        List<Person> personList = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        DataContainer dc = new DataContainer(personList, firestationList, medicalRecordList);

        Assert.assertEquals(firestationList, dc.getFirestations());
        Assert.assertEquals(personList, dc.getPersons());
        Assert.assertEquals(medicalRecordList, dc.getMedicalrecords());
    }

    @Test
    public void personTest() {
        Person person = new Person("John", "Doe", "Neverland", "Funeralopolis", "000", "45", "john.doe@testmail.com");
        String toString = "Person: firstname= John, lastName = Doe, address = Neverland, city = Funeralopolis, zip = 000, phone number = 45, email = john.doe@testmail.com";

        Assert.assertEquals("John", person.getFirstName());
        Assert.assertEquals("Doe", person.getLastName());
        Assert.assertEquals("Neverland", person.getAddress());
        Assert.assertEquals("Funeralopolis", person.getCity());
        Assert.assertEquals("000", person.getZip());
        Assert.assertEquals("45", person.getPhone());
        Assert.assertEquals("john.doe@testmail.com", person.getEmail());
        Assert.assertEquals(toString, person.toString());
    }

    @Test
    public void fireStationTest() {
        Firestation fs = new Firestation("000", "111");
        String toString = "Firestation: address = 000, station number = 111";

        Assert.assertEquals("000", fs.getAddress());
        Assert.assertEquals("111", fs.getStation());
        Assert.assertEquals(toString, fs.toString());
    }

    @Test
    public void medicalRecordTest() throws Exception {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        MedicalRecord mr = new MedicalRecord("John", "Doe", "01/01/01", medication, allergies);
        String toString = "Person: firstname= John, lastName = Doe, birthdate = 01/01/01, medications = [], allergies = []";

        Assert.assertEquals("John", mr.getFirstName());
        Assert.assertEquals("Doe", mr.getLastName());
        Assert.assertEquals("01/01/01", mr.getBirthdate());
        Assert.assertEquals(medication, mr.getMedications());
        Assert.assertEquals(allergies, mr.getAllergies());
        Assert.assertEquals(toString, mr.toString());

    }

    @Test
    public void childAlertTest() throws Exception {
        List<String> family = new ArrayList<>();
        family.add("eee");
        ChildAlert childAlert = new ChildAlert("John", "Doe", 2, family);
        String toString = "Children: firstName= John, lastName = Doe, age= 2, family = [eee]";

        Assert.assertEquals("John", childAlert.getFirstName());
        Assert.assertEquals("Doe", childAlert.getLastName());
        Assert.assertEquals(java.util.Optional.of(2), java.util.Optional.of(childAlert.getAge()));
        Assert.assertEquals(toString, childAlert.toString());
    }

    @Test
    public void fireAlertTest()  {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        List<String> stationNumber = new ArrayList<>();
        stationNumber.add("z");
        FireAlert fa = new FireAlert("John", "Doe", 15, "000", medication, allergies, stationNumber);
        String toString = "Person: firstname= John, lastName = Doe, age = 15, phone number = 000, medications = [], allergies = [], station number = [z]";

        Assert.assertEquals("John", fa.getFirstName());
        Assert.assertEquals("Doe", fa.getLastName());
        Assert.assertEquals(java.util.Optional.of(15), java.util.Optional.of(fa.getAge()));
        Assert.assertEquals("000", fa.getPhone());
        Assert.assertEquals(medication, fa.getMedications());
        Assert.assertEquals(allergies, fa.getAllergies());
        Assert.assertEquals(toString, fa.toString());
    }

    @Test
    public void floodTest() throws Exception {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        Flood flood = new Flood("John", "Doe", 15, "000", medication, allergies);
        String toString = "[ firstname= John, lastName = Doe, age = 15, phone number = 000, medications = [], allergies = []]";

        Assert.assertEquals("John", flood.getFirstName());
        Assert.assertEquals("Doe", flood.getLastName());
        Assert.assertEquals(java.util.Optional.of(15), java.util.Optional.of(flood.getAge()));
        Assert.assertEquals("000", flood.getPhone());
        Assert.assertEquals(medication, flood.getMedications());
        Assert.assertEquals(allergies, flood.getAllergies());
        Assert.assertEquals(toString, flood.toString());
    }

    @Test
    public void householdTest() {
        List<Flood> flood = new ArrayList<>();
        Household hh = new Household("000", flood);
        String toString = "address= 000, person = []";

        Household h = new Household();
        h.setAddress("000");
        h.setFlood(flood);

        Assert.assertEquals("000", hh.getAddress());
        Assert.assertEquals(flood.size(), hh.getFlood().size());
        Assert.assertEquals("000", h.getAddress());
        Assert.assertEquals(toString, hh.toString());
    }

    @Test
    public void personCoveredTest() {
        PersonCovered pc = new PersonCovered("John", "Doe", "000", "000");
        String toString = "[firstName = John, lastName = Doe, address = 000, phone number = 000]";

        Assert.assertEquals("John", pc.getFirstName());
        Assert.assertEquals("Doe", pc.getLastName());
        Assert.assertEquals("000", pc.getAddress());
        Assert.assertEquals("000", pc.getPhone());
        Assert.assertEquals(toString, pc.toString());
    }

    @Test
    public void personInfoTest() throws Exception {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        PersonInfo pi = new PersonInfo("John", "Doe", "000", 15, "000", medication, allergies);
        String toString = "Person: firstname= John, lastName = Doe, address = 000, age = 15, email = 000, medications = [], allergies = []";

        Assert.assertEquals("John", pi.getFirstName());
        Assert.assertEquals("Doe", pi.getLastName());
        Assert.assertEquals("000", pi.getAddress());
        Assert.assertEquals(java.util.Optional.of(15), java.util.Optional.of(pi.getAge()));
        Assert.assertEquals("000", pi.getEmail());
        Assert.assertEquals(medication, pi.getMedications());
        Assert.assertEquals(allergies, pi.getAllergies());
        Assert.assertEquals(toString, pi.toString());
    }

    @Test
    public void stationCoverageTest() throws Exception {
        List<PersonCovered> personCovered = new ArrayList<>();
        StationCoverage sc = new StationCoverage(1, 1, personCovered);
        String toString = "Coverage: adults = 1, child = 1, person covered = []";

        StationCoverage s = new StationCoverage();
        s.setAdults(1);
        s.setChild(1);
        s.setPersonsCovered(personCovered);

        Assert.assertEquals(1, sc.getChild());
        Assert.assertEquals(1, sc.getAdults());
        Assert.assertEquals(personCovered.size(), sc.getPersonsCovered().size());
        Assert.assertEquals(1, s.getChild());
        Assert.assertEquals(1, s.getAdults());
        Assert.assertEquals(toString, sc.toString());
    }

}
