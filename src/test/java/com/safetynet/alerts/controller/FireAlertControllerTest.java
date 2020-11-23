package com.safetynet.alerts.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FireAlertController.class)
@ExtendWith(SpringExtension.class)
public class FireAlertControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FireAlertService fireAlertService;

    @Test
    public void getPersonsByAddress() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("address", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }

    @Test
    public void getPersonsByAddressWithIncorrectParamValue() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("a", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getPersonsByAddressWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/fire")
                .param("address", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }
}
