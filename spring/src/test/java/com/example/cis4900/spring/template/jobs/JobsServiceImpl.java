package com.example.cis4900.spring.template.jobs;


import com.example.cis4900.spring.template.jobs.models.Job;
import com.example.cis4900.spring.template.jobs.models.Employer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobsServiceImplTest {

    private JobsServiceImpl jobsService;

    @BeforeEach
    void setUp() {
        jobsService = new JobsServiceImpl();
    }

    @Test
    void addJob_ReturnsNull() {
        Job newJob = new Job(); 
        assertNull(jobsService.addJob(newJob), "addJob should return null");
    }

    @Test
    void getJob_ReturnsNull() {
        assertNull(jobsService.getJob(1), "getJob should return null");
    }

    @Test
    void updateJob_ReturnsNull() {
        Job updatedJob = new Job(); 
        assertNull(jobsService.updateJob(updatedJob), "updateJob should return null");
    }

    @Test
    void deleteJob_ReturnsNull() {
        assertNull(jobsService.deleteJob(1), "deleteJob should return null");
    }

    @Test
    void allJobs_ReturnsNull() {
        assertNull(jobsService.allJobs(), "allJobs should return null");
    }

    @Test
    void count_ReturnsNull() {
        assertNull(jobsService.count(), "count should return null");
    }
}
