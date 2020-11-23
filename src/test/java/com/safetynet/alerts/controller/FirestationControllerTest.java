package com.safetynet.alerts.controller;


import com.safetynet.alerts.model.PersonCovered;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.FirestationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void deleteFireStationTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.delete("/firestation/delete")
                .param("address", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateFireStationTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.put("/firestation/update")
                .contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"1509 Culver St\",\"station\": \"2\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getFireStationTest() throws Exception {
        PersonCovered pc = new PersonCovered("eee", "eee", "eee", "eee");
        List<PersonCovered> personCoveredList = new ArrayList<>();
        personCoveredList.add(pc);
        StationCoverage sc = new StationCoverage(1, 1, personCoveredList);

        when(firestationService.getPersonsCoverageByStationNumber("3")).thenReturn(sc);

        this.mvc.perform(MockMvcRequestBuilders.get("/firestation")
                .param("stationNumber", "3"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{\"adults\":1,\"child\":1,\"personsCovered\":[{\"firstName\":\"eee\",\"lastName\":\"eee\",\"address\":\"eee\",\"phone\":\"eee\"}]}"));

    }

    @Test
    public void getFireStationTestWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/firestation")
                .param("a", "3"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getFireStationTestWithIncorrectParamValue() throws Exception {
        List<PersonCovered> personCoveredList = new ArrayList<>();
        StationCoverage sc = new StationCoverage(0, 0, personCoveredList);

        when(firestationService.getPersonsCoverageByStationNumber("a")).thenReturn(sc);

        this.mvc.perform(MockMvcRequestBuilders.get("/firestation")
                .param("stationNumber", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("{\"adults\":0,\"child\":0,\"personsCovered\":[]}"));
    }

}
