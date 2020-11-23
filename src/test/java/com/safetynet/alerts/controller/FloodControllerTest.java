package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Flood;
import com.safetynet.alerts.model.Household;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FloodController.class)
@ExtendWith(SpringExtension.class)
public class FloodControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FloodService floodService;

    @Test
    public void getHouseholdByFireStationAddressTest() throws Exception {
        List<Household> hh = new ArrayList<>();
        List<Flood> floodList = new ArrayList<>();
        Flood flood = new Flood("eee", "eee", 15, "000", null, null);
        floodList.add(flood);
        Household household = new Household("eee", floodList);
        hh.add(household);

        when(floodService.getHouseholdByStationAddress("2")).thenReturn(hh);

        this.mvc.perform(MockMvcRequestBuilders.get("/flood/stations")
                .param("stations", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"address\":\"eee\",\"flood\":[{\"firstName\":\"eee\",\"lastName\":\"eee\",\"age\":15,\"phone\":\"000\",\"medications\":null,\"allergies\":null}]}]"));
    }

    @Test
    public void getHouseholdByFireStationAddressTestWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/flood/stations")
                .param("a", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getHouseholdByFireStationAddressTestWithIncorrectParamValue() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/flood/stations")
                .param("stations", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }
}
