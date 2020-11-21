package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommunityAlertServiceTest {

    private static CommunityEmailService communityEmailService;

    private static DataContainer dataContainer;

    @BeforeAll
    private static void setup() {
        dataContainer = mock(DataContainer.class);
        communityEmailService = new CommunityEmailService(dataContainer);
    }

    @Test
    public void getEmailList() {
        List<Person> listPersons = new ArrayList<>();

        Person person1 = new Person();
        person1.setEmail("test@testmail.com");
        person1.setCity("Culver");
        listPersons.add(person1);

        Person person2 = new Person();
        person2.setEmail("test2@testmail.com");
        person2.setCity("Culver");
        listPersons.add(person2);

        Person person3 = new Person();
        person3.setEmail("test3@testmail.com");
        person3.setCity("Culver");
        listPersons.add(person3);

        when(dataContainer.getPersons()).thenReturn(listPersons);

        Assert.assertNotNull(communityEmailService.getEmailByCity("Culver"));
        Assert.assertEquals(3, communityEmailService.getEmailByCity("Culver").size());
    }
}
