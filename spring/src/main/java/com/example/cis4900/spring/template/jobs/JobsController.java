package com.example.cis4900.spring.template.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jobs")
public class JobsController {

    private Job job;

    // template for jobs API

    @GetMapping()
    public List<Job> getAllJobs() {
        return null;
    }

    @GetMapping("/{id}")
    public String getJobInfo(){
        return null;
    }

    @GetMapping("/{id}/applies")
    public String getLink(){
        return null;
    }

    @GetMapping("/{locations}")
    public List<Job> getJobsLocation() {
        return null;
    }

    @GetMapping("/{locations}/{distances}")
    public List<Job> getJobsWithin() {
        return null;
    }

    @GetMapping("/{types}")
    public List<Job> getJobsType() {
        return null;
    }

    @GetMapping("/{wages}")
    public List<Job> getJobsWage() {
        return null;
    }

    @GetMapping("/{industries}")
    public List<Job> getJobsIndustry() {
        return null;
    }

    @GetMapping("/{companyRatings}")
    public List<Job> getJobsRating() {
        return null;
    }

    @GetMapping("/{dates}")
    public List<Job> getJobsDate() {
        return null;
    }

    @GetMapping("/{keywords}")
    public List<Job> getJobsKeyword() {
        return null;
    }

}