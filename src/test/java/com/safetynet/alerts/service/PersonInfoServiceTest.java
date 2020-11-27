package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonInfoServiceTest {

    private static PersonInfoService personInfoService;

    private static DataContainer dataContainer;

    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        MedicalRecordService medicalRecordService = new MedicalRecordService(dataContainer);
        personInfoService = new PersonInfoService(dataContainer, medicalRecordService);
    }

    //Test the getPersonInformation method from PersonInfoService
    // it must return a PersonInfo List
    @Test
    public void getPersonInfoTest() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("test");
        person.setEmail("test@testmail.com");
        personList.add(person);

        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        medicalRecord.setAllergies(allergies);
        medicalRecord.setMedications(medications);
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);

        List<PersonInfo> personInfoList = new ArrayList<>();
        PersonInfo personInfo = new PersonInfo("John", "Boyd", "test", 36, "test@testmail.com", medications, allergies);
        personInfoList.add(personInfo);

        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation("John", "Boyd"));
        Assert.assertEquals(personInfoList.toString(), personInfoService.getPersonInformation("John", "Boyd").toString());

    }

    //Test the getPersonInformation method from PersonInfoService when the parameters doesn't match anything
    // it must return an empty PersonInfo List
    @Test
    public void getPersonInfoWithNoDataTest() {
        List<Person> personList = new ArrayList<>();
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        List<PersonInfo> personInfoList = new ArrayList<>();

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("test");
        person.setEmail("test@testmail.com");
        personList.add(person);

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        medicalRecord.setAllergies(allergies);
        medicalRecord.setMedications(medications);
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);


        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation("John", "Doe"));
        Assert.assertEquals(personInfoList.toString() ,personInfoService.getPersonInformation("John", "Doe").toString());
    }

    //Test the getPersonInformation method from PersonInfoService when the parameters doesn't match anything
    // it must return an empty PersonInfo List
    @Test
    public void getPersonInfoWithIncorrectParamTest() {
        List<Person> personList = new ArrayList<>();
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        List<PersonInfo> personInfoList = new ArrayList<>();

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("test");
        person.setEmail("test@testmail.com");
        personList.add(person);

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        medicalRecord.setAllergies(allergies);
        medicalRecord.setMedications(medications);
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);

        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation("", ""));
        Assert.assertEquals(personInfoList.toString() ,personInfoService.getPersonInformation("", "").toString());
    }
}
