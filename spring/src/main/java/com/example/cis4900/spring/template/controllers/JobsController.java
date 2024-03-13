package com.example.cis4900.spring.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.cis4900.spring.template.jobs.models.Job;
import com.example.cis4900.spring.template.jobs.JobsService;

import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping(path = "api/jobs") // has to be API or React can't see it. I don't know why - Tyler
public class JobsController {

    private JobsService jobsService;

    @Autowired
    JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    // template for jobs API

    @GetMapping()
    private @ResponseBody Iterable<Job> getAllJobs() {
        System.out.println("Hello from getAllJobs()");
        return jobsService.allJobs();
    }

    @GetMapping("/test")
    private @ResponseBody Iterable<Job> getTestJobs() {
        Vector<Job> dummyJobVector = new Vector<Job>();
        dummyJobVector
                .add(new Job(0, "Dummy Title One", "Dummy Desc One", "Dummy Location One",
                        1000.0f, 2000.0f, 456456));
        dummyJobVector
                .add(new Job(0, "Dummy Title Two", "Dummy Desc Two", "Dummy Location Two",
                        1000.0f, 2000.0f, 456456));
        System.out.println("Hello from getTestJobs()");

        return dummyJobVector;
    }

    @GetMapping("/{id}")
    public String getJobInfo() {
        return null;
    }

    @GetMapping("/{id}/applies")
    public String getLink() {
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