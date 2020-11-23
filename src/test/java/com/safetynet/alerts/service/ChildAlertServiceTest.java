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

import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ChildAlertServiceTest {

    private static ChildAlertService childAlertService;

    private static DataContainer dataContainer;

    private static MedicalRecordService medicalRecordService;


    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        medicalRecordService = new MedicalRecordService(dataContainer);
        childAlertService = new ChildAlertService(dataContainer, medicalRecordService);
    }

    @Test
    public void getChildFromListWhenThereIsTwoChild() {
        List<Person> listPersons = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        listPersons.add(person);

        Person person1 = new Person();
        person1.setFirstName("Jacob");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Tenley");
        person2.setLastName("Boyd");
        person2.setAddress("1509 Culver St");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Roger");
        person3.setLastName("Boyd");
        person3.setAddress("1509 Culver St");
        listPersons.add(person3);

        Person person4 = new Person();
        person4.setFirstName("Felicia");
        person4.setLastName("Boyd");
        person4.setAddress("1509 Culver St");
        listPersons.add(person4);

        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        listMedicalrecords.add(medicalRecord);

        MedicalRecord medicalRecord1 = new MedicalRecord();
        medicalRecord1.setFirstName("Jacob");
        medicalRecord1.setLastName("Boyd");
        medicalRecord1.setBirthdate("03/06/1989");
        listMedicalrecords.add(medicalRecord1);

        MedicalRecord medicalRecord2 = new MedicalRecord();
        medicalRecord2.setFirstName("Tenley");
        medicalRecord2.setLastName("Boyd");
        medicalRecord2.setBirthdate("02/18/2012");
        listMedicalrecords.add(medicalRecord2);

        MedicalRecord medicalRecord3 = new MedicalRecord();
        medicalRecord3.setFirstName("Roger");
        medicalRecord3.setLastName("Boyd");
        medicalRecord3.setBirthdate("09/06/2017");
        listMedicalrecords.add(medicalRecord3);

        MedicalRecord medicalRecord4 = new MedicalRecord();
        medicalRecord4.setFirstName("Felicia");
        medicalRecord4.setLastName("Boyd");
        medicalRecord4.setBirthdate("01/08/1986");
        listMedicalrecords.add(medicalRecord4);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        Assert.assertNotNull(childAlertService.getChildByAddress("1509 Culver St"));
        Assert.assertEquals(2, childAlertService.getChildByAddress("1509 Culver St").size());
    }

    @Test
    public void getChildFromListWhenThereIsNoChild() {
        List<Person> listPersons = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        listPersons.add(person1);

        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        listMedicalrecords.add(medicalRecord);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        Assert.assertNotNull(childAlertService.getChildByAddress("1509 Culver St"));
        Assert.assertEquals(0, childAlertService.getChildByAddress("1509 Culver St").size());
    }

    @Test
    public void getChildFromListWhenThereIsNoData() {
        List<Person> listPersons = new ArrayList<>();
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        Assert.assertNotNull(childAlertService.getChildByAddress("1509 Culver St"));
        Assert.assertEquals(0, childAlertService.getChildByAddress("1509 Culver St").size());
    }

    @Test
    public void getChildFromListWhenThereIsNoCity() {
        List<Person> listPersons = new ArrayList<>();
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        Assert.assertNotNull(childAlertService.getChildByAddress(null));
        Assert.assertEquals(0, childAlertService.getChildByAddress(null).size());
    }
}
