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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PhoneAlertController.class)
@ExtendWith(SpringExtension.class)
public class PhoneAlertControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PhoneAlertService phoneAlertService;

    @Test
    public void getPhoneNumbersByStationTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/phoneAlert")
                .param("firestation", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }

    @Test
    public void getPhoneNumbersByStationTestWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/phoneAlert")
                .param("a", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getPhoneNumbersByStationTestWithIncorrectParamValue() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/phoneAlert")
                .param("firestation", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }
}
