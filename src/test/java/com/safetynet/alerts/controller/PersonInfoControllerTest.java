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

import java.util.ArrayList;
import java.util.List;

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

    // Test the getAPersonInformation method when the request is correct
    // It must return a 200 status and a json array
    @Test
    public void getPersonInformationTest() throws Exception {

        PersonInfo pi = new PersonInfo("John", "Boyd", "000", 15, "000", null, null);
        List<PersonInfo> personInfoList = new ArrayList<>();
        personInfoList.add(pi);

        when(personInfoService.getPersonInformation("John", "Boyd")).thenReturn(personInfoList);

        this.mvc.perform(MockMvcRequestBuilders.get("/personInfo")
                .param("firstName", "John").param("lastName", "Boyd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"000\",\"age\":15,\"email\":\"000\",\"medications\":null,\"allergies\":null}]"));
    }

    // Test the getAPersonInformation method when the request parameter name is incorrect
    // It must return a 400 status
    @Test
    public void getPersonInformationTestWithIncorrectParamName() throws Exception {

        this.mvc.perform(MockMvcRequestBuilders.get("/personInfo")
                .param("a", "John").param("lastName", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    // Test the getAPersonInformation method when the request parameter value is incorrect
    // It must return a 200 status and an empty json array
    @Test
    public void getPersonInformationTestWithIncorrectParamValue() throws Exception {
        List<PersonInfo> personInfoList = new ArrayList<>();

        when(personInfoService.getPersonInformation("", "")).thenReturn(personInfoList);

        this.mvc.perform(MockMvcRequestBuilders.get("/personInfo")
                .param("firstName", "").param("lastName", ""))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }

}
