package com.safetynet.alerts.controller;


import com.safetynet.alerts.service.MedicalRecordService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicalRecordController.class)
@ExtendWith(SpringExtension.class)
public class MedicalRecordControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MedicalRecordService medicalRecordService;

    // test the add method
    @Test
    public void addMedicalRecordTest() throws Exception {
        this.mvc.perform(post("/medicalRecord/add")
                .contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"AAAA\",\"lastName\": \"BBBB\",\"birthdate\": \"01/10/1987\",\"medications\": [\"aznol:350mg\",\"hydrapermazol:100mg\"],\"allergies\":[\"nillacila111\"]}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    // test the delete method
    @Test
    public void deleteMedicalRecordTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.delete("/medicalRecord/delete")
                .param("firstName", "Eric").param("lastName", "Cadigan"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    // test the update method
    @Test
    public void updateMedicalRecordTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.put("/medicalRecord/update")
                .contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Jacob\",\"lastName\": \"Boyd\",\"birthdate\": \"01/10/1987\",\"medications\": [\"aznoly:350mg\",\"hydrapermazol:100mg\"],\"allergies\":[\"nillacilan\"]}").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().is2xxSuccessful());
    }



}
