package com.example.cis4900.spring.template.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(GGSController.class)
public class GGSControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getDummyDataTest() throws Exception {
        mockMvc.perform(get("/api/ggs/dummyData"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("one line of data"))
                .andExpect(jsonPath("$[1]").value("another line of data"))
                .andExpect(jsonPath("$[2]").value("one final line of data"));
    }

    @Test
    public void getHardCodedJSONTest() throws Exception {
        mockMvc.perform(get("/api/ggs/hardCodedJSON"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.jobs[0].job.job_title").value("Software Engineer"))
                .andExpect(jsonPath("$.jobs[1].job.job_title").value("Hardware Engineer"))
                .andExpect(jsonPath("$.jobs[2].job.job_title").value("Tech Support"));
    }
}
