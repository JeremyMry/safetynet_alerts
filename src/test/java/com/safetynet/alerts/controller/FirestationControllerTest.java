package com.safetynet.alerts.controller;


import com.safetynet.alerts.service.FirestationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FirestationController.class)
@ExtendWith(SpringExtension.class)
public class FirestationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FirestationService firestationService;

    @Test
    public void addFireStationTest() throws Exception {
        this.mvc.perform(post("/firestation/add")
                .contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"7777 XXXXX Ddddd\",\"station\": \"1\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteFireStationTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.delete("/firestation/delete")
                .param("address", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateFireStationTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.put("/firestation/update")
                .contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"1509 Culver St\",\"station\": \"2\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getFireStationTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/firestation")
                .param("stationNumber", "3"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

}
