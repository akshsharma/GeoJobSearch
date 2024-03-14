package com.example.cis4900.spring.template.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.cis4900.spring.template.jobs.JobsService;
import com.example.cis4900.spring.template.jobs.models.Job;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JobsController.class)
public class JobsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobsService jobsService;

    private List<Job> dummyJobs = Arrays.asList(
            new Job(1, "Dummy Title One", "Dummy Desc One", "Dummy Location One", 1000.0f, 2000.0f, 456456),
            new Job(2, "Dummy Title Two", "Dummy Desc Two", "Dummy Location Two", 1500.0f, 2500.0f, 123123)
    );

    @Test
    public void getAllJobsTest() throws Exception {
        given(jobsService.allJobs()).willReturn(dummyJobs); 

        mockMvc.perform(get("/api/jobs")) 
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(dummyJobs.get(0).getId()))
                .andExpect(jsonPath("$[0].title").value("Dummy Title One"))
                .andExpect(jsonPath("$[1].title").value("Dummy Title Two"));
    }

    @Test
    public void getTestJobsTest() throws Exception {
        mockMvc.perform(get("/api/jobs/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Dummy Title One"))
                .andExpect(jsonPath("$[0].description").value("Dummy Desc One"))
                .andExpect(jsonPath("$[0].location").value("Dummy Location One"))
                .andExpect(jsonPath("$[1].title").value("Dummy Title Two"))
                .andExpect(jsonPath("$[1].description").value("Dummy Desc Two"))
                .andExpect(jsonPath("$[1].location").value("Dummy Location Two"));
    }

}
