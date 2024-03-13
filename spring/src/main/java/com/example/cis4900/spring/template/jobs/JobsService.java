package com.example.cis4900.spring.template.jobs;

import com.example.cis4900.spring.template.jobs.models.Job;

public interface JobsService {
    String addJob(Job newJob);

    Job getJob(Integer id);
    
    String updateJob(Job updatedJob);

    String deleteJob(Integer id);

    Iterable<Job> allJobs();

    Integer count();
}