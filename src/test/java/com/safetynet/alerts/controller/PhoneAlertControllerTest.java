package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.ChildAlertService;
import com.safetynet.alerts.service.PhoneAlertService;
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

@WebMvcTest(PhoneAlertController.class)
@ExtendWith(SpringExtension.class)
public class PhoneAlertControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PhoneAlertService phoneAlertService;

    // Test the getPhoneNumbersByCoverageStation method when the request is correct
    // It must return a 200 status and a json array containing the response
    @Test
    public void getPhoneNumbersByStationTest() throws Exception {
        List<String> stringList = new ArrayList<>();
        stringList.add("000");

        when(phoneAlertService.getPhoneNumberByCoverage("2")).thenReturn(stringList);

        this.mvc.perform(MockMvcRequestBuilders.get("/phoneAlert")
                .param("firestation", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[\"000\"]"));
    }

    // Test the getPhoneNumbersByCoverageStation method when the request parameter name is incorrect
    // It must return a 400 status
    @Test
    public void getPhoneNumbersByStationTestWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/phoneAlert")
                .param("a", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    // Test the getPhoneNumbersByCoverageStation method when the request parameter value is incorrect
    // It must return a 200 status and a json array containing the error message
    @Test
    public void getPhoneNumbersByStationTestWithIncorrectParamValue() throws Exception {
        List<String> stringList = new ArrayList<>();

        when(phoneAlertService.getPhoneNumberByCoverage("a")).thenReturn(stringList);

        this.mvc.perform(MockMvcRequestBuilders.get("/phoneAlert")
                .param("firestation", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[\"The request 'a' doesn't match anything or is incorrect\"]"));
    }
}
