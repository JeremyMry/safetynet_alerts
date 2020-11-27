package com.safetynet.alerts.service;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ChildAlertServiceTest {

    private static ChildAlertService childAlertService;

    private static DataContainer dataContainer;


    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        MedicalRecordService medicalRecordService = new MedicalRecordService(dataContainer);
        childAlertService = new ChildAlertService(dataContainer, medicalRecordService);
    }

    // test the getChildByAddress method from ChildAlertService class
    // it must return a List of ChildAlert
    @Test
    public void getChildFromListWhenThereIsTwoChild() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        personList.add(person);

        Person person1 = new Person();
        person1.setFirstName("Jacob");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        personList.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Tenley");
        person2.setLastName("Boyd");
        person2.setAddress("1509 Culver St");
        personList.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Roger");
        person3.setLastName("Boyd");
        person3.setAddress("1509 Culver St");
        personList.add(person3);

        Person person4 = new Person();
        person4.setFirstName("Felicia");
        person4.setLastName("Boyd");
        person4.setAddress("1509 Culver St");
        personList.add(person4);

        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);

        MedicalRecord medicalRecord1 = new MedicalRecord();
        medicalRecord1.setFirstName("Jacob");
        medicalRecord1.setLastName("Boyd");
        medicalRecord1.setBirthdate("03/06/1989");
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

        MedicalRecord medicalRecord4 = new MedicalRecord();
        medicalRecord4.setFirstName("Felicia");
        medicalRecord4.setLastName("Boyd");
        medicalRecord4.setBirthdate("01/08/1986");
        medicalRecordList.add(medicalRecord4);

        List<ChildAlert> childAlertList = new ArrayList<>();
        List<String> family = new ArrayList<>();
        family.add("John Boyd");
        family.add("Jacob Boyd");
        family.add("Felicia Boyd");
         ChildAlert childAlert = new ChildAlert("Tenley", "Boyd", 8, family);
         ChildAlert childAlert1 = new ChildAlert("Roger", "Boyd", 3, family);
         childAlertList.add(childAlert);
         childAlertList.add(childAlert1);


        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(childAlertService.getChildByAddress("1509 Culver St"));
        Assert.assertEquals(childAlertList.toString(), childAlertService.getChildByAddress("1509 Culver St").toString());
    }

    // test the getChildByAddress method from ChildAlertService class when there is no child in the address
    // it must return an empty List of ChildAlert
    @Test
    public void getChildFromListWhenThereIsNoChild() {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        personList.add(person1);

        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);

        List<ChildAlert> childAlertList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(childAlertService.getChildByAddress("1509 Culver St"));
        Assert.assertEquals(childAlertList.toString(), childAlertService.getChildByAddress("1509 Culver St").toString());
    }

    // test the getChildByAddress method from ChildAlertService class when the address is incorrect
    // it must return an empty List of ChildAlert
    @Test
    public void getChildFromListWhenThereIsNoData() {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        personList.add(person1);

        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        listMedicalrecords.add(medicalRecord);

        List<ChildAlert> childAlertList = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(personList);
        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        Assert.assertNotNull(childAlertService.getChildByAddress(""));
        Assert.assertEquals(childAlertList.toString(), childAlertService.getChildByAddress("").toString());
    }
}
