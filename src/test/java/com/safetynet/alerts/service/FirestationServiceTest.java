package com.safetynet.alerts.service;

import com.safetynet.alerts.model.*;
import net.bytebuddy.build.ToStringPlugin;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FirestationServiceTest {

    private static FirestationService firestationService;

    private static MedicalRecordService medicalRecordService;

    private static DataContainer dataContainer;

    @BeforeAll
    private static void setUp() {
        dataContainer = mock(DataContainer.class);
        medicalRecordService = new MedicalRecordService(dataContainer);
        firestationService = new FirestationService(dataContainer, medicalRecordService);
    }

    @Test
    public void testAdd () throws Exception {
        List<Firestation> listFirestation = new ArrayList<>();

        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");

        listFirestation.add(firestation);

        Firestation firestation2 = new Firestation();
        firestation2.setAddress("29 15th St");
        firestation2.setStation("2");

        listFirestation.add(firestation2);

        Firestation firestation3 = new Firestation();
        firestation3.setAddress("834 Binoc Ave");
        firestation3.setStation("3");

        listFirestation.add(firestation3);

        Firestation firestation4 = new Firestation();
        firestation4.setAddress("644 Gershwin Cir");
        firestation4.setStation("1");

        listFirestation.add(firestation4);

        Firestation firestation5 = new Firestation();
        firestation5.setAddress("748 Townings Dr");
        firestation5.setStation("3");

        listFirestation.add(firestation5);

        Firestation firestation6 = new Firestation();
        firestation6.setAddress("112 Steppes Pl");
        firestation6.setStation("3");

        listFirestation.add(firestation6);

        Firestation firestation7 = new Firestation();
        firestation7.setAddress("489 Manchester St");
        firestation7.setStation("4");

        listFirestation.add(firestation7);

        Firestation firestation8 = new Firestation();
        firestation8.setAddress("892 Downing Ct");
        firestation8.setStation("2");

        listFirestation.add(firestation8);

        Firestation firestation9 = new Firestation();
        firestation9.setAddress("908 73rd St");
        firestation9.setStation("1");

        listFirestation.add(firestation9);

        Firestation firestation10 = new Firestation();
        firestation10.setAddress("112 Steppes Pl");
        firestation10.setStation("4");

        listFirestation.add(firestation10);

        Firestation firestation11 = new Firestation();
        firestation11.setAddress("947 E. Rose Dr");
        firestation11.setStation("1");

        listFirestation.add(firestation11);

        Firestation firestation12 = new Firestation();
        firestation12.setAddress("748 Townings Dr");
        firestation12.setStation("3");

        listFirestation.add(firestation12);

        Firestation firestation13 = new Firestation();
        firestation13.setAddress("951 LoneTree Rd");
        firestation13.setStation("2");

        listFirestation.add(firestation13);

        assertEquals(13, listFirestation.size());

        Firestation newFirestation = new Firestation();
        newFirestation.setAddress("ZZZZ");
        newFirestation.setStation("3");

        when(dataContainer.getFirestations()).thenReturn(listFirestation);
        listFirestation = firestationService.add(newFirestation);
        assertEquals(14, listFirestation.size());
        assertEquals(newFirestation.getAddress(), listFirestation.get(13).getAddress());
    }


    @Test
    public void testUpdate () throws Exception {
        List<Firestation> listFirestation = new ArrayList<>();

        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");

        listFirestation.add(firestation);

        Firestation firestation2 = new Firestation();
        firestation2.setAddress("29 15th St");
        firestation2.setStation("2");

        listFirestation.add(firestation2);

        Firestation firestation3 = new Firestation();
        firestation3.setAddress("834 Binoc Ave");
        firestation3.setStation("3");

        listFirestation.add(firestation3);

        Firestation firestation4 = new Firestation();
        firestation4.setAddress("644 Gershwin Cir");
        firestation4.setStation("1");

        listFirestation.add(firestation4);

        Firestation firestation5 = new Firestation();
        firestation5.setAddress("748 Townings Dr");
        firestation5.setStation("3");

        listFirestation.add(firestation5);

        Firestation firestation6 = new Firestation();
        firestation6.setAddress("112 Steppes Pl");
        firestation6.setStation("3");

        listFirestation.add(firestation6);

        Firestation firestation7 = new Firestation();
        firestation7.setAddress("489 Manchester St");
        firestation7.setStation("4");

        listFirestation.add(firestation7);

        Firestation firestation8 = new Firestation();
        firestation8.setAddress("892 Downing Ct");
        firestation8.setStation("2");

        listFirestation.add(firestation8);

        Firestation firestation9 = new Firestation();
        firestation9.setAddress("908 73rd St");
        firestation9.setStation("1");

        listFirestation.add(firestation9);

        Firestation firestation10 = new Firestation();
        firestation10.setAddress("112 Steppes Pl");
        firestation10.setStation("4");

        listFirestation.add(firestation10);

        Firestation firestation11 = new Firestation();
        firestation11.setAddress("947 E. Rose Dr");
        firestation11.setStation("1");

        listFirestation.add(firestation11);

        Firestation firestation12 = new Firestation();
        firestation12.setAddress("748 Townings Dr");
        firestation12.setStation("3");

        listFirestation.add(firestation12);

        Firestation firestation13 = new Firestation();
        firestation13.setAddress("951 LoneTree Rd");
        firestation13.setStation("2");

        listFirestation.add(firestation13);

        assertEquals(13, listFirestation.size());
        assertEquals("2", listFirestation.get(12).getStation());

        Firestation updatedFirestation = new Firestation();
        updatedFirestation.setAddress("951 LoneTree Rd");
        updatedFirestation.setStation("1");

        when(dataContainer.getFirestations()).thenReturn(listFirestation);
        listFirestation = firestationService.update(updatedFirestation);

        assertEquals(13, listFirestation.size());
        assertEquals("1", listFirestation.get(12).getStation());
    }

    @Test
    public void testDelete () throws Exception {
        List<Firestation> listFirestation = new ArrayList<>();

        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");

        listFirestation.add(firestation);

        Firestation firestation2 = new Firestation();
        firestation2.setAddress("29 15th St");
        firestation2.setStation("2");

        listFirestation.add(firestation2);

        Firestation firestation3 = new Firestation();
        firestation3.setAddress("834 Binoc Ave");
        firestation3.setStation("3");

        listFirestation.add(firestation3);

        Firestation firestation4 = new Firestation();
        firestation4.setAddress("644 Gershwin Cir");
        firestation4.setStation("1");

        listFirestation.add(firestation4);

        Firestation firestation5 = new Firestation();
        firestation5.setAddress("748 Townings Dr");
        firestation5.setStation("3");

        listFirestation.add(firestation5);

        Firestation firestation6 = new Firestation();
        firestation6.setAddress("112 Steppes Pl");
        firestation6.setStation("3");

        listFirestation.add(firestation6);

        Firestation firestation7 = new Firestation();
        firestation7.setAddress("489 Manchester St");
        firestation7.setStation("4");

        listFirestation.add(firestation7);

        Firestation firestation8 = new Firestation();
        firestation8.setAddress("892 Downing Ct");
        firestation8.setStation("2");

        listFirestation.add(firestation8);

        Firestation firestation9 = new Firestation();
        firestation9.setAddress("908 73rd St");
        firestation9.setStation("1");

        listFirestation.add(firestation9);

        Firestation firestation10 = new Firestation();
        firestation10.setAddress("112 Steppes Pl");
        firestation10.setStation("4");

        listFirestation.add(firestation10);

        Firestation firestation11 = new Firestation();
        firestation11.setAddress("947 E. Rose Dr");
        firestation11.setStation("1");

        listFirestation.add(firestation11);

        Firestation firestation12 = new Firestation();
        firestation12.setAddress("748 Townings Dr");
        firestation12.setStation("3");

        listFirestation.add(firestation12);

        Firestation firestation13 = new Firestation();
        firestation13.setAddress("951 LoneTree Rd");
        firestation13.setStation("2");

        listFirestation.add(firestation13);

        assertEquals(13, listFirestation.size());
        assertEquals("951 LoneTree Rd", listFirestation.get(12).getAddress());
        assertEquals("2", listFirestation.get(12).getStation());

        when(dataContainer.getFirestations()).thenReturn(listFirestation);
        listFirestation = firestationService.delete(firestation.getAddress());

        assertEquals(12, listFirestation.size());
    }

    @Test
    public void getPeoplesCoverageStationTest() {
        List<Person> listPersons = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        person1.setPhone("841-874-6512");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Jacob");
        person2.setLastName("Boyd");
        person2.setAddress("1509 Culver St");
        person2.setPhone("841-874-6513");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Tenley");
        person3.setLastName("Boyd");
        person3.setAddress("1509 Culver St");
        person3.setPhone("841-874-6512");
        listPersons.add(person3);

        Person person4 = new Person();
        person4.setFirstName("Roger");
        person4.setLastName("Boyd");
        person4.setAddress("1509 Culver St");
        person4.setPhone("841-874-6512");
        listPersons.add(person4);

        List<Firestation> listFirestation = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        listFirestation.add(firestation);

        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setFirstName("John");
        medicalRecord.setLastName("Boyd");
        medicalRecord.setBirthdate("03/06/1984");
        medicalRecordList.add(medicalRecord);

        MedicalRecord medicalRecord1 = new MedicalRecord();
        medicalRecord1.setFirstName("Jacob");
        medicalRecord1.setLastName("Boyd");
        medicalRecord1.setBirthdate("03/06/1984");
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

        List<PersonCovered> personCoveredList = new ArrayList<>();

        PersonCovered personCovered = new PersonCovered();
        personCovered.setFirstName("John");
        personCovered.setLastName("Boyd");
        personCovered.setAddress("1509 Culver St");
        personCovered.setPhone("841-874-6512");
        personCoveredList.add(personCovered);

        PersonCovered personCovered1 = new PersonCovered();
        personCovered1.setFirstName("Jacob");
        personCovered1.setLastName("Boyd");
        personCovered1.setAddress("1509 Culver St");
        personCovered1.setPhone("841-874-6513");
        personCoveredList.add(personCovered1);

        PersonCovered personCovered2 = new PersonCovered();
        personCovered2.setFirstName("Tenley");
        personCovered2.setLastName("Boyd");
        personCovered2.setAddress("1509 Culver St");
        personCovered2.setPhone("841-874-6512");
        personCoveredList.add(personCovered2);

        PersonCovered personCovered3= new PersonCovered();
        personCovered3.setFirstName("Roger");
        personCovered3.setLastName("Boyd");
        personCovered3.setAddress("1509 Culver St");
        personCovered3.setPhone("841-874-6512");
        personCoveredList.add(personCovered3);

        StationCoverage test = new StationCoverage(2, 2, personCoveredList);

        when(dataContainer.getPersons()).thenReturn(listPersons);
        when(dataContainer.getFirestations()).thenReturn(listFirestation);
        when(dataContainer.getMedicalrecords()).thenReturn(medicalRecordList);

        Assert.assertNotNull(firestationService.getPeoplesCoverageStation("3"));
        Assert.assertTrue(new ReflectionEquals(test.getAdults()).matches(firestationService.getPeoplesCoverageStation("3").getAdults()));
        Assert.assertTrue(new ReflectionEquals(test.getChild()).matches(firestationService.getPeoplesCoverageStation("3").getChild()));
        Assert.assertTrue(new ReflectionEquals(test.getPersonsCovered()).matches(firestationService.getPeoplesCoverageStation("3").getPersonsCovered()));
    }

    @Test
    public void getFirestationStationNumberByAddressTest() {
        List<Firestation> listFirestation = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        listFirestation.add(firestation);
        List<String> actual = new ArrayList<>();
        actual.add("3");

        when(dataContainer.getFirestations()).thenReturn(listFirestation);

        Assert.assertNotNull(firestationService.getFirestationStationNumberByAddress("1509 Culver St"));
        Assert.assertEquals(1, firestationService.getFirestationStationNumberByAddress("1509 Culver St").size());
        Assert.assertArrayEquals(actual.toArray(), firestationService.getFirestationStationNumberByAddress("1509 Culver St").toArray());
    }

    @Test
    public void getFirestationStationNumberByAddressWithNoParamTest() {
        List<Firestation> listFirestation = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        listFirestation.add(firestation);
        List<String> actual = new ArrayList<>();
        actual.add("3");

        when(dataContainer.getFirestations()).thenReturn(listFirestation);

        Assert.assertNotNull(firestationService.getFirestationStationNumberByAddress(null));
        Assert.assertEquals(0, firestationService.getFirestationStationNumberByAddress(null).size());
    }

    @Test
    public void getFirestationAddressByStationNumberTest() {
        List<Firestation> listFirestation = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        listFirestation.add(firestation);
        List<String> actual = new ArrayList<>();
        actual.add("1509 Culver St");

        when(dataContainer.getFirestations()).thenReturn(listFirestation);

        Assert.assertNotNull(firestationService.getFirestationAddressByStationNumber("3"));
        Assert.assertEquals(1, firestationService.getFirestationAddressByStationNumber("3").size());
        Assert.assertArrayEquals(actual.toArray(), firestationService.getFirestationAddressByStationNumber("3").toArray());
    }

    @Test
    public void getFirestationAddressByStationNumberWithNoParamTest() {
        List<Firestation> listFirestation = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setAddress("1509 Culver St");
        firestation.setStation("3");
        listFirestation.add(firestation);
        List<String> actual = new ArrayList<>();
        actual.add("1509 Culver St");

        when(dataContainer.getFirestations()).thenReturn(listFirestation);

        Assert.assertNotNull(firestationService.getFirestationAddressByStationNumber(null));
        Assert.assertEquals(0, firestationService.getFirestationAddressByStationNumber(null).size());
    }
}
