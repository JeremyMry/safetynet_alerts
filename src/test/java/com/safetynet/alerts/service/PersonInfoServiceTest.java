package com.safetynet.alerts.service;

import com.safetynet.alerts.SafetynetAlertsApplication;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
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

    private static MedicalRecordService medicalRecordService;

    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        medicalRecordService = new MedicalRecordService(dataContainer);
        personInfoService = new PersonInfoService(dataContainer, medicalRecordService);
    }

    @Test
    public void getPersonInfo() {
        List<Person> listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("test");
        person.setEmail("test@testmail.com");
        listPersons.add(person);

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

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation("John", "Boyd"));
        Assert.assertEquals("John" ,personInfoService.getPersonInformation("John", "Boyd").getFirstName());
        Assert.assertEquals("Boyd" ,personInfoService.getPersonInformation("John", "Boyd").getLastName());
        Assert.assertEquals("test" ,personInfoService.getPersonInformation("John", "Boyd").getAddress());
        Assert.assertEquals("test@testmail.com" ,personInfoService.getPersonInformation("John", "Boyd").getEmail());
        Assert.assertEquals(36 ,personInfoService.getPersonInformation("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoData() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation("John", "Boyd"));
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformation("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoFirstName() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation(null, "Boyd"));
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformation("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoLastName() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation("eee", null));
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformation("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoName() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformation(null, null));
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformation("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformation("John", "Boyd").getAge());
    }
}
