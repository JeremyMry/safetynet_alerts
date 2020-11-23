package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.service.ChildAlertService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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

@WebMvcTest(ChildAlertController.class)
@ExtendWith(SpringExtension.class)
public class ChildAlertControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ChildAlertService childAlertService;

    @Test
    public void getChildByAddressTest() throws Exception {
        List<String> family = new ArrayList<>();
        ChildAlert ca = new ChildAlert("eee", "eee", 15, family);
        List<ChildAlert> childAlertList = new ArrayList<>();
        childAlertList.add(ca);
        when(childAlertService.getChildByAddress("1509 Culver St")).thenReturn(childAlertList);

        this.mvc.perform(MockMvcRequestBuilders.get("/childAlert")
                .param("address", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"firstName\":\"eee\",\"lastName\":\"eee\",\"age\":15,\"family\":[]}]"));
    }

    @Test
    public void getChildByAddressTestWithIncorrectParamName() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/childAlert")
                .param("a", "1509 Culver St"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getChildByAddressTestWithIncorrectParamValue() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/childAlert")
                .param("address", "a"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[]"));
    }
}
