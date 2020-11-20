package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.ChildAlertService;
import com.safetynet.alerts.service.FloodService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FloodController.class)
@ExtendWith(SpringExtension.class)
public class FloodControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FloodService floodService;

    @Test
    public void getFloodStationsTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/flood/stations")
                .param("stations", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
