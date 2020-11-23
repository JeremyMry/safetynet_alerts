package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.PersonService;
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

@WebMvcTest(PersonController.class)
@ExtendWith(SpringExtension.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService service;

    @Test
    public void addPersonTest() throws Exception {
        this.mvc.perform(post("/person/add")
                .contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\",\"lastName\": \"\",\"address\": \"\",\"city\": \"\",\"zip\": \"\",\"phone\": \"\",\"email\": \"\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void deletePersonTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.delete("/person/delete")
                .param("firstName", "Eric").param("lastName", "Cadigan"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updatePersonTest() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.put("/person/update")
                .contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Jacob\",\"lastName\": \"Boyd\",\"address\": \"157 dum street\",\"city\": \"ZZZ\",\"zip\": \"15874\",\"phone\": \"825-854-6513\",\"email\": \"Jacob@gmail.com\"}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }
}
