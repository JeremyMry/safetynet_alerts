package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.FireAlert;
import com.safetynet.alerts.service.CommunityEmailService;
import com.safetynet.alerts.service.FireAlertService;
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


@WebMvcTest(FireAlertController.class)
@ExtendWith(SpringExtension.class)
public class FireAlertControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FireAlertService fireAlertService;

    // Test the getPersonsByAddress method when the request is correct
    // It must return a 200 status and json array containing the response
    @Test
    public void getPersonsByAddress() throws Exception {
        List<FireAlert> fireAlertList = new ArrayList<>();
        FireAlert fa = new FireAlert("John", "Doe", 15, "000", null, null, null);
        fireAlertList.add(fa);
        when(fireAlertService.getPersonsByAddress("1509 Culver St")).thenReturn(fireAlertList);

        this.mvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("address", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":15,\"phone\":\"000\",\"medications\":null,\"allergies\":null,\"stationNumber\":null}]"));
    }

    // Test the getPersonsByAddress method when the request parameter name is incorrect
    // It must return a 400 status and an error message
    @Test
    public void getPersonsByAddressWithIncorrectParamValue() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("a", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError())
                .andExpect(status().reason("Required String parameter 'address' is not present"));
    }

    // Test the getPersonsByAddress method when the request parameter value is incorrect
    // It must return a 200 status and a json array containing an error message
    @Test
    public void getPersonsByAddressWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("address", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[\"The request 'a' doesn't match anything or is incorrect\"]"));
    }
}
