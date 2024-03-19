package com.example.cis4900.spring.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                        1000.0f, 2000.0f, 456456, "Dummy Link 1.1", "Dummy Link 1.2"));
        dummyJobVector
                .add(new Job(0, "Dummy Title Two", "Dummy Desc Two", "Dummy Location Two",
                        1000.0f, 2000.0f, 456456, "Dummy Link 2.1", "Dummy Link 2.2"));
        System.out.println("Hello from getTestJobs()");

        return dummyJobVector;
    }

    @GetMapping("/{id}")
    public Job getJobInfo(@PathVariable Integer id) {
        return jobsService.getJob(id);
    }

    @GetMapping("/{id}/applies")
    public String getLink() {
        return null;
    }

    @GetMapping("/{id}/{locations}")
    public List<Job> getJobsLocation() {
        return null;
    }

    @GetMapping("/{id}/{locations}/{distances}")
    public List<Job> getJobsWithin() {
        return null;
    }

    @GetMapping("/{id}/{types}")
    public List<Job> getJobsType() {
        return null;
    }

    @GetMapping("{id}//{wages}")
    public List<Job> getJobsWage() {
        return null;
    }

    @GetMapping("/{id}/{industries}")
    public List<Job> getJobsIndustry() {
        return null;
    }

    @GetMapping("/{id}/{companyRatings}")
    public List<Job> getJobsRating() {
        return null;
    }

    @GetMapping("/{id}/{dates}")
    public List<Job> getJobsDate() {
        return null;
    }

    @GetMapping("/{id}/{keywords}")
    public List<Job> getJobsKeyword() {
        return null;
    }

}