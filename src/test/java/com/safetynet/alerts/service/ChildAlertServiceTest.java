package com.safetynet.alerts.service;

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
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
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

        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        MedicalRecord medicalrecord1 = new MedicalRecord();
        medicalrecord1.setFirstName("John");
        medicalrecord1.setLastName("Boyd");
        medicalrecord1.setBirthdate("03/06/1984");
        listMedicalrecords.add(medicalrecord1);

        MedicalRecord medicalrecord2 = new MedicalRecord();
        medicalrecord2.setFirstName("Jacob");
        medicalrecord2.setLastName("Boyd");
        medicalrecord2.setBirthdate("03/06/1989");
        listMedicalrecords.add(medicalrecord2);

        MedicalRecord medicalrecord3 = new MedicalRecord();
        medicalrecord3.setFirstName("Tenley");
        medicalrecord3.setLastName("Boyd");
        medicalrecord3.setBirthdate("02/18/2012");
        listMedicalrecords.add(medicalrecord3);

        MedicalRecord medicalrecord4 = new MedicalRecord();
        medicalrecord4.setFirstName("Roger");
        medicalrecord4.setLastName("Boyd");
        medicalrecord4.setBirthdate("09/06/2017");
        listMedicalrecords.add(medicalrecord4);

        MedicalRecord medicalrecord5 = new MedicalRecord();
        medicalrecord5.setFirstName("Felicia");
        medicalrecord5.setLastName("Boyd");
        medicalrecord5.setBirthdate("01/08/1986");
        listMedicalrecords.add(medicalrecord5);

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

        MedicalRecord medicalrecord1 = new MedicalRecord();
        medicalrecord1.setFirstName("John");
        medicalrecord1.setLastName("Boyd");
        medicalrecord1.setBirthdate("03/06/1984");
        listMedicalrecords.add(medicalrecord1);

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
