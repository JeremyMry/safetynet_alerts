package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.FirestationService;
import com.safetynet.alerts.service.FloodService;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonInfoService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
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
        medicalRecord.setAllergies(new String[0]);
        medicalRecord.setMedications(new String[0]);
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformations("John", "Boyd"));
        Assert.assertEquals("John" ,personInfoService.getPersonInformations("John", "Boyd").getFirstName());
        Assert.assertEquals("Boyd" ,personInfoService.getPersonInformations("John", "Boyd").getLastName());
        Assert.assertEquals("test" ,personInfoService.getPersonInformations("John", "Boyd").getAddress());
        Assert.assertEquals("test@testmail.com" ,personInfoService.getPersonInformations("John", "Boyd").getEmail());
        Assert.assertEquals(36 ,personInfoService.getPersonInformations("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoData() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformations("John", "Boyd"));
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformations("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoFirstName() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformations(null, "Boyd"));
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformations("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoLastName() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformations("eee", null));
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformations("John", "Boyd").getAge());
    }

    @Test
    public void getPersonInfoWithNoName() {
        List<Person> listPersons = new ArrayList<>();

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(personInfoService.getPersonInformations(null, null));
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getFirstName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getLastName());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getAddress());
        Assert.assertNull(null ,personInfoService.getPersonInformations("John", "Boyd").getEmail());
        Assert.assertEquals(0 ,personInfoService.getPersonInformations("John", "Boyd").getAge());
    }
}
