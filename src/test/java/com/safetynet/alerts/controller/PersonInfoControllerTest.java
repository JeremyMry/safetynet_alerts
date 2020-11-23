package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.MedicalRecordService;
import com.safetynet.alerts.service.PersonInfoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonInfoController.class)
@ExtendWith(SpringExtension.class)
public class PersonInfoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonInfoService personInfoService;


    @Test
    public void getPersonInformationTest() throws Exception {

        PersonInfo pi = new PersonInfo("John", "Boyd", "000", 15, "000", null, null);

        when(personInfoService.getPersonInformation("John", "Boyd")).thenReturn(pi);

        this.mvc.perform(MockMvcRequestBuilders.get("/personInfo")
                .param("firstName", "John").param("lastName", "Boyd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"000\",\"age\":15,\"email\":\"000\",\"medications\":null,\"allergies\":null}"));
    }

    @Test
    public void getPersonInformationTestWithIncorrectParamName() throws Exception {

        this.mvc.perform(MockMvcRequestBuilders.get("/personInfo")
                .param("a", "John").param("lastName", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getPersonInformationTestWithIncorrectParamValue() throws Exception {
        PersonInfo pi = new PersonInfo();

        when(personInfoService.getPersonInformation("a", "a")).thenReturn(pi);

        this.mvc.perform(MockMvcRequestBuilders.get("/personInfo")
                .param("firstName", "a").param("lastName", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{}"));
    }

}
