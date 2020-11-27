package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

    private static MedicalRecordService medicalRecordService;

    private static DataContainer dataContainer;

    @BeforeAll
    private static void setUp() {
        dataContainer = mock(DataContainer.class);
        medicalRecordService = new MedicalRecordService(dataContainer);
    }

    // test the add method from MedicalRecordService class
    // it must add a MedicalRecord to the List of MedicalRecord and then return the List of MedicalRecord with the new one added
    @Test
    public void addTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("09/06/2000");
        List<String>  allergies = new ArrayList<>();
        allergies.add("shellfish");
        medicalRecord.setAllergies(allergies);
        List<String>  medications = new ArrayList<>();
        medicalRecord.setMedications(medications);
        medicalRecordList.add(medicalRecord);

        MedicalRecord newMedicalrecord = new MedicalRecord();
        newMedicalrecord.setFirstName("John");
        newMedicalrecord.setLastName("Doe");
        newMedicalrecord.setBirthdate("01/10/1999");
        List<String> allergies7 = new ArrayList<>();
        newMedicalrecord.setAllergies(allergies7);
        List<String> medications7 = new ArrayList<>();
        medications7.add("doliprane:1000mg");
        newMedicalrecord.setMedications(medications7);

        List<MedicalRecord> medicalRecordList1 = new ArrayList<>();
        medicalRecordList1.add(medicalRecord);
        medicalRecordList1.add(newMedicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList1);

        assertEquals(3, medicalRecordService.add(newMedicalrecord).size());
        assertEquals(newMedicalrecord.getFirstName(), medicalRecordList1.get(1).getFirstName());
    }

    // test the update method from MedicalRecordService class
    // it must update a MedicalRecord from the List of MedicalRecord and then return the List of MedicalRecord with the MedicalRecord updated
    @Test
    public void updateTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("John");
        medicalrecord.setLastName("Boyd");
        medicalrecord.setBirthdate("03/06/1985");
        List<String> allergies = new ArrayList<>();
        medicalrecord.setAllergies(allergies);
        List<String> medications = new ArrayList<>();
        medications.add("noxidian:100mg");
        medications.add("pharmacol:2500mg");
        medicalrecord.setMedications(medications);

        medicalRecordList.add(medicalrecord);

        MedicalRecord updatedMedicalrecord = new MedicalRecord();
        updatedMedicalrecord.setFirstName("John");
        updatedMedicalrecord.setLastName("Boyd");
        updatedMedicalrecord.setBirthdate("01/10/1980");

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals("01/10/1980", medicalRecordService.update(updatedMedicalrecord).get(0).getBirthdate());
    }

    // test the update method from MedicalRecordService class with unknown param
    // it must return the MedicalRecord list with no change
    @Test
    public void updateWithWrongParamTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1985");
        List<String> allergies = new ArrayList<>();
        medicalRecord.setAllergies(allergies);
        List<String> medications = new ArrayList<>();
        medications.add("noxidian:100mg");
        medications.add("pharmacol:2500mg");
        medicalRecord.setMedications(medications);

        medicalRecordList.add(medicalRecord);

        MedicalRecord updatedMedicalRecord = new MedicalRecord();
        updatedMedicalRecord.setFirstName("John");
        updatedMedicalRecord.setLastName("Doe");

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(medicalRecordList.toString(), medicalRecordService.update(updatedMedicalRecord).toString());
    }

    @Test
    public void updateWithWrongParamTest2() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1985");
        List<String> allergies = new ArrayList<>();
        medicalRecord.setAllergies(allergies);
        List<String> medications = new ArrayList<>();
        medications.add("noxidian:100mg");
        medications.add("pharmacol:2500mg");
        medicalRecord.setMedications(medications);

        medicalRecordList.add(medicalRecord);

        MedicalRecord updatedMedicalRecord = new MedicalRecord();
        updatedMedicalRecord.setFirstName("Paul");
        updatedMedicalRecord.setLastName("Boyd");

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(medicalRecordList.toString(), medicalRecordService.update(updatedMedicalRecord).toString());
    }


    // test the delete method from MedicalRecordService class
    // it must delete a MedicalRecord from the List of MedicalRecord and then return the List of MedicalRecord without the MedicalRecord deleted
    @Test
    public void deleteTest()  {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Peter");
        medicalRecord.setLastName("Duncan");
        medicalRecord.setBirthdate("09/06/2000");
        List<String> allergies = new ArrayList<>();
        allergies.add("shellfish");
        medicalRecord.setAllergies(allergies);
        List<String> medications = new ArrayList<>();
        medicalRecord.setMedications(medications);
        medicalRecordList.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(0, medicalRecordService.delete(medicalRecord.getFirstName(), medicalRecord.getLastName()).size());
    }

    // test the delete method from MedicalRecordService class with unknown param
    // it must the  List of MedicalRecord with no changes
    @Test
    public void deleteTestWithIncorrectParamTest()  {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Peter");
        medicalRecord.setLastName("Duncan");
        medicalRecord.setBirthdate("09/06/2000");
        List<String> allergies = new ArrayList<>();
        allergies.add("shellfish");
        medicalRecord.setAllergies(allergies);
        List<String> medications = new ArrayList<>();
        medicalRecord.setMedications(medications);

        medicalRecordList.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(medicalRecordList.toString(), medicalRecordService.delete("Peter", "ee").toString());
    }

    @Test
    public void deleteTestWithIncorrectParamTest2()  {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Peter");
        medicalRecord.setLastName("Duncan");
        medicalRecord.setBirthdate("09/06/2000");
        List<String> allergies = new ArrayList<>();
        allergies.add("shellfish");
        medicalRecord.setAllergies(allergies);
        List<String> medications = new ArrayList<>();
        medicalRecord.setMedications(medications);

        medicalRecordList.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(medicalRecordList.toString(), medicalRecordService.delete("ee", "Duncan").toString());
    }

    // test the getAge method from the MedicalRecordService class
    // it must return an Integer
    @Test
    public void getAgeTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        medicalRecord.setBirthdate("12/06/1975");
        medicalRecordList.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotEquals(0, medicalRecordService.getAge("Brian", "Stelzer"));
        assertEquals(44, medicalRecordService.getAge("Brian", "Stelzer"));
    }

    // test the getAge method from the MedicalRecordService class when the parameters doesn't match anything
    // it must return 0
    @Test
    public void getAgeWithNoDataTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        medicalRecord.setBirthdate("12/06/1975");
        medicalRecordList.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(0, medicalRecordService.getAge("Brian", "Doe"));
    }

    // test the getAge method from the MedicalRecordService class when the parameters doesn't match anything
    // it must return 0
    @Test
    public void getAgeWithNoDataTest2() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        medicalRecord.setBirthdate("12/06/1975");
        medicalRecordList.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(0, medicalRecordService.getAge("John", "Stelzer"));
    }

    // test the getAge method from the MedicalRecordService class when the parameters are incorrect
    // it must return 0
    @Test
    public void getAgeWithNoParamTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        medicalRecord.setBirthdate("12/06/1975");
        medicalRecordList.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertEquals(0, medicalRecordService.getAge("", ""));
    }

    // test the getMedication method from MedicalRecordService class
    // it must return a List of medications
    @Test
    public void getMedicationsTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> medication = new ArrayList<>();
        medication.add("ibupurin:200mg");
        medication.add("hydrapermazol:400mg");
        medicalRecord.setMedications(medication);
        medicalRecordList.add(medicalRecord);


        List<String> medication1 = new ArrayList<>();
        medication1.add("ibupurin:200mg");
        medication1.add("hydrapermazol:400mg");

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getMedications("Brian", "Stelzer"));
        assertEquals(medication1, medicalRecordService.getMedications("Brian", "Stelzer"));
    }

    // test the getMedication method from MedicalRecordService class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getMedicationsWithIncorrectParamTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> medication = new ArrayList<>();
        medication.add("ibupurin:200mg");
        medication.add("hydrapermazol:400mg");
        medicalRecord.setMedications(medication);
        medicalRecordList.add(medicalRecord);

        List<String> medication1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getMedications("John", "Stelzer"));
        assertEquals(medication1, medicalRecordService.getMedications("John", "Stelzer"));
    }

    // test the getMedication method from MedicalRecordService class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getMedicationsWithIncorrectParamTest2() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> medication = new ArrayList<>();
        medication.add("ibupurin:200mg");
        medication.add("hydrapermazol:400mg");
        medicalRecord.setMedications(medication);
        medicalRecordList.add(medicalRecord);

        List<String> medication1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getMedications("Brian", "Doe"));
        assertEquals(medication1, medicalRecordService.getMedications("Brian", "Doe"));
    }

    // test the getMedication method from MedicalRecordService class when the parameters are incorrect
    // it must return an empty List
    @Test
    public void getMedicationsWithNoDataTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> medication = new ArrayList<>();
        medication.add("ibupurin:200mg");
        medication.add("hydrapermazol:400mg");
        medicalRecord.setMedications(medication);
        medicalRecordList.add(medicalRecord);

        List<String> medication1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getMedications("", ""));
        assertEquals(medication1, medicalRecordService.getMedications("", ""));
    }

    // test the get Allergies method from the MedicalRecord class
    // it must return a List of allergies
    @Test
    public void getAllergiesTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> allergies = new ArrayList<>();
        allergies.add("nillacilan");
        medicalRecord.setAllergies(allergies);
        medicalRecordList.add(medicalRecord);

        List<String> allergies1 = new ArrayList<>();
        allergies1.add("nillacilan");
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getAllergies("Brian", "Stelzer"));
        assertEquals(allergies1, medicalRecordService.getAllergies("Brian", "Stelzer"));
    }

    // test the get Allergies method from the MedicalRecord class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getAllergiesWithNoDataTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> allergies = new ArrayList<>();
        allergies.add("nillacilan");
        medicalRecord.setAllergies(allergies);
        medicalRecordList.add(medicalRecord);

        List<String> allergies1 = new ArrayList<>();
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getAllergies("",""));
        assertEquals(allergies1, medicalRecordService.getAllergies("",""));
    }

    // test the get Allergies method from the MedicalRecord class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getAllergiesWithNoIncorrectParamTest() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> allergies = new ArrayList<>();
        allergies.add("nillacilan");
        medicalRecord.setAllergies(allergies);
        medicalRecordList.add(medicalRecord);

        List<String> allergies1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getAllergies("Brian", "Doe"));
        assertEquals(allergies1, medicalRecordService.getAllergies("Brian", "Doe"));
    }

    // test the get Allergies method from the MedicalRecord class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getAllergiesWithNoIncorrectParamTest2() {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Brian");
        medicalRecord.setLastName("Stelzer");
        List<String> allergies = new ArrayList<>();
        allergies.add("nillacilan");
        medicalRecord.setAllergies(allergies);
        medicalRecordList.add(medicalRecord);

        List<String> allergies1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        assertNotNull(medicalRecordService.getAllergies("John", "Stelzer"));
        assertEquals(allergies1, medicalRecordService.getAllergies("John", "Stelzer"));
    }

}
