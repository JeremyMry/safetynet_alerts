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

    @Test
    public void testAdd() throws Exception {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        MedicalRecord medicalrecord1 = new MedicalRecord();
        medicalrecord1.setFirstName("Peter");
        medicalrecord1.setLastName("Duncan");
        medicalrecord1.setBirthdate("09/06/2000");
        String[] allergies = { "shellfish" };
        medicalrecord1.setAllergies(allergies);
        String[] medications = { "" };
        medicalrecord1.setMedications(medications);
        listMedicalrecords.add(medicalrecord1);

        MedicalRecord medicalrecord2 = new MedicalRecord();
        medicalrecord2.setFirstName("Reginold");
        medicalrecord2.setLastName("Walker");
        medicalrecord2.setBirthdate("08/30/1979");
        String[] allergies2 = { "illisoxian" };
        medicalrecord2.setAllergies(allergies2);
        String[] medications2 = { "thradox:700mg" };
        medicalrecord2.setMedications(medications2);
        listMedicalrecords.add(medicalrecord2);

        MedicalRecord medicalrecord3 = new MedicalRecord();
        medicalrecord3.setFirstName("Jamie");
        medicalrecord3.setLastName("Peters");
        medicalrecord3.setBirthdate("03/06/1982");
        String[] allergies3 = { "" };
        medicalrecord3.setAllergies(allergies3);
        String[] medications3 = { "" };
        medicalrecord3.setMedications(medications3);
        listMedicalrecords.add(medicalrecord3);

        MedicalRecord medicalrecord4 = new MedicalRecord();
        medicalrecord4.setFirstName("Brian");
        medicalrecord4.setLastName("Stelzer");
        medicalrecord4.setBirthdate("12/06/1975");
        String[] allergies4 = { "nillacilan" };
        medicalrecord4.setAllergies(allergies4);
        String[] medications4 = { "ibupurin:200mg", "hydrapermazol:400mg" };
        medicalrecord4.setMedications(medications4);
        listMedicalrecords.add(medicalrecord4);

        MedicalRecord medicalrecord5 = new MedicalRecord();
        medicalrecord5.setFirstName("Shawna");
        medicalrecord5.setLastName("Stelzer");
        medicalrecord5.setBirthdate("07/08/1980");
        String[] allergies5 = { "" };
        medicalrecord5.setAllergies(allergies5);
        String[] medications5 = { "" };
        medicalrecord5.setMedications(medications5);
        listMedicalrecords.add(medicalrecord5);

        MedicalRecord medicalrecord6 = new MedicalRecord();
        medicalrecord6.setFirstName("Kendrik");
        medicalrecord6.setLastName("Stelzer");
        medicalrecord6.setBirthdate("03/06/2014");
        String[] allergies6 = { "" };
        medicalrecord6.setAllergies(allergies6);
        String[] medications6 = { "noxidian:100mg", "pharmacol:2500mg" };
        medicalrecord6.setMedications(medications6);
        listMedicalrecords.add(medicalrecord6);

        MedicalRecord newMedicalrecord = new MedicalRecord();
        newMedicalrecord.setFirstName("AAAAAA");
        newMedicalrecord.setLastName("BBBBBB");
        newMedicalrecord.setBirthdate("01/10/1987");
        String[] allergies7 = { "" };
        newMedicalrecord.setAllergies(allergies7);
        String[] medications7 = { "doliprane:100mg" };
        newMedicalrecord.setMedications(medications7);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertEquals(7, medicalRecordService.add(newMedicalrecord).size());
        assertEquals(newMedicalrecord.getFirstName(), listMedicalrecords.get(6).getFirstName());
    }

    /**@Test
    public void testUpdate() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();

        MedicalRecord medicalrecord1 = new MedicalRecord();
        medicalrecord1.setFirstName("Peter");
        medicalrecord1.setLastName("Duncan");
        medicalrecord1.setBirthdate("09/06/2000");
        String[] allergies = { "shellfish" };
        medicalrecord1.setAllergies(allergies);
        String[] medications = { "" };
        medicalrecord1.setMedications(medications);

        listMedicalrecords.add(medicalrecord1);

        MedicalRecord medicalrecord2 = new MedicalRecord();
        medicalrecord2.setFirstName("Reginold");
        medicalrecord2.setLastName("Walker");
        medicalrecord2.setBirthdate("08/30/1979");
        String[] allergies2 = { "illisoxian" };
        medicalrecord2.setAllergies(allergies2);
        String[] medications2 = { "thradox:700mg" };
        medicalrecord2.setMedications(medications2);

        listMedicalrecords.add(medicalrecord2);

        MedicalRecord medicalrecord3 = new MedicalRecord();
        medicalrecord3.setFirstName("Jamie");
        medicalrecord3.setLastName("Peters");
        medicalrecord3.setBirthdate("03/06/1982");
        String[] allergies3 = { "" };
        medicalrecord3.setAllergies(allergies3);
        String[] medications3 = { "" };
        medicalrecord3.setMedications(medications3);

        listMedicalrecords.add(medicalrecord3);

        MedicalRecord medicalrecord4 = new MedicalRecord();
        medicalrecord4.setFirstName("Brian");
        medicalrecord4.setLastName("Stelzer");
        medicalrecord4.setBirthdate("12/06/1975");
        String[] allergies4 = { "nillacilan" };
        medicalrecord4.setAllergies(allergies4);
        String[] medications4 = { "ibupurin:200mg", "hydrapermazol:400mg" };
        medicalrecord4.setMedications(medications4);

        listMedicalrecords.add(medicalrecord4);

        MedicalRecord medicalrecord5 = new MedicalRecord();
        medicalrecord5.setFirstName("Shawna");
        medicalrecord5.setLastName("Stelzer");
        medicalrecord5.setBirthdate("07/08/1980");
        String[] allergies5 = { "" };
        medicalrecord5.setAllergies(allergies5);
        String[] medications5 = { "" };
        medicalrecord5.setMedications(medications5);

        listMedicalrecords.add(medicalrecord5);

        MedicalRecord medicalrecord6 = new MedicalRecord();
        medicalrecord6.setFirstName("Kendrik");
        medicalrecord6.setLastName("Stelzer");
        medicalrecord6.setBirthdate("03/06/2014");
        String[] allergies6 = { "" };
        medicalrecord6.setAllergies(allergies6);
        String[] medications6 = { "noxidian:100mg", "pharmacol:2500mg" };
        medicalrecord6.setMedications(medications6);

        listMedicalrecords.add(medicalrecord6);

        MedicalRecord updatedMedicalrecord = new MedicalRecord();
        updatedMedicalrecord.setFirstName("Kendrik");
        updatedMedicalrecord.setLastName("Stelzer");
        updatedMedicalrecord.setBirthdate("01/10/1987");

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertEquals("01/10/1987", medicalRecordService.update(updatedMedicalrecord).get(5).getBirthdate());
    }**/

    @Test
    public void testDelete() throws Exception {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord1 = new MedicalRecord();
        medicalrecord1.setFirstName("Peter");
        medicalrecord1.setLastName("Duncan");
        medicalrecord1.setBirthdate("09/06/2000");
        String[] allergies = { "shellfish" };
        medicalrecord1.setAllergies(allergies);
        String[] medications = { "" };
        medicalrecord1.setMedications(medications);

        listMedicalrecords.add(medicalrecord1);

        MedicalRecord medicalrecord2 = new MedicalRecord();
        medicalrecord2.setFirstName("Reginold");
        medicalrecord2.setLastName("Walker");
        medicalrecord2.setBirthdate("08/30/1979");
        String[] allergies2 = { "illisoxian" };
        medicalrecord2.setAllergies(allergies2);
        String[] medications2 = { "thradox:700mg" };
        medicalrecord2.setMedications(medications2);

        listMedicalrecords.add(medicalrecord2);

        MedicalRecord medicalrecord3 = new MedicalRecord();
        medicalrecord3.setFirstName("Jamie");
        medicalrecord3.setLastName("Peters");
        medicalrecord3.setBirthdate("03/06/1982");
        String[] allergies3 = { "" };
        medicalrecord3.setAllergies(allergies3);
        String[] medications3 = { "" };
        medicalrecord3.setMedications(medications3);

        listMedicalrecords.add(medicalrecord3);

        MedicalRecord medicalrecord4 = new MedicalRecord();
        medicalrecord4.setFirstName("Brian");
        medicalrecord4.setLastName("Stelzer");
        medicalrecord4.setBirthdate("12/06/1975");
        String[] allergies4 = { "nillacilan" };
        medicalrecord4.setAllergies(allergies4);
        String[] medications4 = { "ibupurin:200mg", "hydrapermazol:400mg" };
        medicalrecord4.setMedications(medications4);

        listMedicalrecords.add(medicalrecord4);

        MedicalRecord medicalrecord5 = new MedicalRecord();
        medicalrecord5.setFirstName("Shawna");
        medicalrecord5.setLastName("Stelzer");
        medicalrecord5.setBirthdate("07/08/1980");
        String[] allergies5 = { "" };
        medicalrecord5.setAllergies(allergies5);
        String[] medications5 = { "" };
        medicalrecord5.setMedications(medications5);

        listMedicalrecords.add(medicalrecord5);

        MedicalRecord medicalrecord6 = new MedicalRecord();
        medicalrecord6.setFirstName("Kendrik");
        medicalrecord6.setLastName("Stelzer");
        medicalrecord6.setBirthdate("03/06/2014");
        String[] allergies6 = { "" };
        medicalrecord5.setAllergies(allergies6);
        String[] medications6 = { "" };
        medicalrecord5.setMedications(medications6);

        listMedicalrecords.add(medicalrecord6);

        assertEquals(6, listMedicalrecords.size());

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);
        listMedicalrecords = medicalRecordService.delete(medicalrecord6.getFirstName(), medicalrecord6.getLastName());

        assertEquals(5, listMedicalrecords.size());
    }

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

    @Test
    public void getAgeTestWithNoParam() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        medicalrecord.setBirthdate("12/06/1975");
        listMedicalrecords.add(medicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertEquals(0, medicalRecordService.getAge(null, null));
    }

    @Test
    public void getMedications() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        String[] medication = { "ibupurin:200mg", "hydrapermazol:400mg" };
        medicalrecord.setMedications(medication);
        listMedicalrecords.add(medicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getMedications("Brian", "Stelzer"));
        assertArrayEquals(new String[]{"ibupurin:200mg", "hydrapermazol:400mg"}, medicalRecordService.getMedications("Brian", "Stelzer"));
    }

    @Test
    public void getMedicationsWithNoParam() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        listMedicalrecords.add(medicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getMedications(null, null));
        assertArrayEquals(new String[0], medicalRecordService.getMedications(null, null));
    }

    @Test
    public void getAllergies() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        String[] allergies = { "nillacilan" };
        medicalrecord.setAllergies(allergies);
        listMedicalrecords.add(medicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getAllergies("Brian", "Stelzer"));
        assertArrayEquals(new String[]{ "nillacilan" }, medicalRecordService.getAllergies("Brian", "Stelzer"));
    }

    @Test
    public void getAllergiesWithNoParam() {
        List<MedicalRecord> listMedicalrecords = new ArrayList<>();
        MedicalRecord medicalrecord = new MedicalRecord();
        medicalrecord.setFirstName("Brian");
        medicalrecord.setLastName("Stelzer");
        listMedicalrecords.add(medicalrecord);

        when(dataContainer.getMedicalrecords()).thenReturn(listMedicalrecords);

        assertNotNull(medicalRecordService.getAllergies(null, null));
        assertArrayEquals(new String[0], medicalRecordService.getAllergies(null, null));
    }

}
