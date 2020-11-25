package com.safetynet.alerts.service;

import com.safetynet.alerts.SafetynetAlertsApplication;
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
    public void testAdd() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("09/06/2000");
        List<String>  allergies = new ArrayList<>();
        allergies.add("shellfish");
        medicalRecord.setAllergies(allergies);
        List<String>  medications = new ArrayList<>();
        medicalRecord.setMedications(medications);
        listMedicalrecords.add(medicalRecord);

        MedicalRecord newMedicalrecord = new MedicalRecord();
        newMedicalrecord.setFirstName("John");
        newMedicalrecord.setLastName("Doe");
        newMedicalrecord.setBirthdate("01/10/1999");
        List<String> allergies7 = new ArrayList<>();
        newMedicalrecord.setAllergies(allergies7);
        List<String> medications7 = new ArrayList<>();
        medications7.add("doliprane:1000mg");
        newMedicalrecord.setMedications(medications7);

        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        medicalRecordList.add(medicalRecord);
        medicalRecordList.add(newMedicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertEquals(medicalRecordList.toString(), medicalRecordService.add(newMedicalrecord).toString());
        assertEquals(newMedicalrecord.getFirstName(), listMedicalrecords.get(1).getFirstName());
    }

    // test the update method from MedicalRecordService class
    // it must update a MedicalRecord from the List of MedicalRecord and then return the List of MedicalRecord with the MedicalRecord updated
    @Test
    public void testUpdate() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

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

        listMedicalrecords.add(medicalrecord);

        MedicalRecord updatedMedicalrecord = new MedicalRecord();
        updatedMedicalrecord.setFirstName("John");
        updatedMedicalrecord.setLastName("Boyd");
        updatedMedicalrecord.setBirthdate("01/10/1980");

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertEquals("01/10/1980", medicalRecordService.update(updatedMedicalrecord).get(0).getBirthdate());
    }

    // test the delete method from MedicalRecordService class
    // it must delete a MedicalRecord from the List of MedicalRecord and then return the List of MedicalRecord without the MedicalRecord deleted
    @Test
    public void testDelete()  {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("Peter");
        medicalRecord.setLastName("Duncan");
        medicalRecord.setBirthdate("09/06/2000");
        List<String> allergies = new ArrayList<>();
        allergies.add("shellfish");
        medicalRecord.setAllergies(allergies);
        List<String> medications = new ArrayList<>();
        medicalRecord.setMedications(medications);

        listMedicalrecords.add(medicalRecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);
        listMedicalrecords = medicalRecordService.delete(medicalRecord.getFirstName(), medicalRecord.getLastName());

        assertEquals(0, listMedicalrecords.size());
    }

    // test the getAge method from the MedicalRecordService class
    // it must return an Integer
    @Test
    public void getAgeTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        medicalrecord.setBirthdate("12/06/1975");
        listMedicalrecords.add(medicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotEquals(0, medicalRecordService.getAge("Brian", "Stelzer"));
        assertEquals(44, medicalRecordService.getAge("Brian", "Stelzer"));
    }

    // test the getAge method from the MedicalRecordService class when the parameters doesn't match anything
    // it must return 0
    @Test
    public void getAgeWithNoDataTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        medicalrecord.setBirthdate("12/06/1975");
        listMedicalrecords.add(medicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertEquals(0, medicalRecordService.getAge("John", "Doe"));
    }

    // test the getAge method from the MedicalRecordService class when the parameters are incorrect
    // it must return 0
    @Test
    public void getAgeWithNoParamTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertEquals(0, medicalRecordService.getAge("", ""));
    }

    // test the getMedication method from MedicalRecordService class
    // it must return a List of medications
    @Test
    public void getMedicationsTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        List<String> medication = new ArrayList<>();
        medication.add("ibupurin:200mg");
        medication.add("hydrapermazol:400mg");
        medicalrecord.setMedications(medication);
        listMedicalrecords.add(medicalrecord);


        List<String> medication1 = new ArrayList<>();
        medication1.add("ibupurin:200mg");
        medication1.add("hydrapermazol:400mg");

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getMedications("Brian", "Stelzer"));
        assertEquals(medication1, medicalRecordService.getMedications("Brian", "Stelzer"));
    }

    // test the getMedication method from MedicalRecordService class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getMedicationsWithIncorrectParamTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        listMedicalrecords.add(medicalrecord);

        List<String> medication1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getMedications("John", "Doe"));
        assertEquals(medication1, medicalRecordService.getMedications("John", "Doe"));
    }

    // test the getMedication method from MedicalRecordService class when the parameters are incorrect
    // it must return an empty List
    @Test
    public void getMedicationsWithNoDataTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        List<String> medication1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getMedications("", ""));
        assertEquals(medication1, medicalRecordService.getMedications("", ""));
    }

    // test the get Allergies method from the MedicalRecord class
    // it must return a List of allergies
    @Test
    public void getAllergiesTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        List<String> allergies = new ArrayList<>();
        allergies.add("nillacilan");
        medicalrecord.setAllergies(allergies);
        listMedicalrecords.add(medicalrecord);

        List<String> allergies1 = new ArrayList<>();
        allergies1.add("nillacilan");
        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getAllergies("Brian", "Stelzer"));
        assertEquals(allergies1, medicalRecordService.getAllergies("Brian", "Stelzer"));
    }

    // test the get Allergies method from the MedicalRecord class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getAllergiesWithNoDataTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        listMedicalrecords.add(medicalrecord);

        List<String> allergies1 = new ArrayList<>();
        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getAllergies("John","Doe"));
        assertEquals(allergies1, medicalRecordService.getAllergies("John","Doe"));
    }

    // test the get Allergies method from the MedicalRecord class when the parameters doesn't match anything
    // it must return an empty List
    @Test
    public void getAllergiesWithNoIncorrectParamTest() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        List<String> allergies1 = new ArrayList<>();

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getAllergies("", ""));
        assertEquals(allergies1, medicalRecordService.getAllergies("", ""));
    }

}
