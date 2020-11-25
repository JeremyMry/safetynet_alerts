package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.CommunityEmailService;
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

@WebMvcTest(CommunityEmailController.class)
@ExtendWith(SpringExtension.class)
public class CommunityEmailControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CommunityEmailService communityEmailService;

    // Test the getEmailsByCity method when the request is correct
    // It must return a 200 status and json array
    @Test
    public void getEmailTestByCity() throws Exception {
        List<String> email = new ArrayList<>();
        email.add("john.doe@testmail.com");
        when(communityEmailService.getEmailByCity("Culver")).thenReturn(email);

        this.mvc.perform(MockMvcRequestBuilders.get("/communityEmail")
                .param("city", "Culver"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[john.doe@testmail.com]"));
    }

    // Test the getEmailsByCity method when the request parameter name is incorrect
    // It must return a 400 status
    @Test
    public void getEmailTestByCityWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/communityEmail")
                .param("a", "Culver"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    // Test the getEmailsByCity method when the request parameter value is incorrect
    // It must return a 200 status and an empty json array
    @Test
    public void getEmailTestByCityWithIncorrectParamValue() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/communityEmail")
                .param("city", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }
}
