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
@RequestMapping(path = "/api") // has to be API or React can't see it. I don't know why - Tyler
public class JobsController {
    
    private JobsService jobsService;

    @Autowired
    JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    // methods from GGSController

    @GetMapping("ggs/dummyData")
    public List<String> getDummy() {
        // return "hello from ggs!";
        // return dummyService.getDummyData();
        List<String> myVector = new Vector<String>();
        myVector.add("one line of data");
        myVector.add("another line of data");
        myVector.add("one final line of data");

        return myVector;
    }

    @GetMapping("ggs/hardCodedJSON") // hard coded JSON
    public String getHardCodedJSON(){
        // Vector<JSONObject> myVector = new Vector<String>();
        // myVector.add("{\"Job Title\": \"Software Engineer\"}");
        // myVector.add("lafjeklajfljfakl");
        return  "{\r\n" + //
                        "  \"jobs\":\r\n" + //
                        "  [\r\n" + //
                        "      {\r\n" + //
                        "          \"job\": {\r\n" + //
                        "              \"job_id\":\"1\",\r\n" + //
                        "              \"job_title\":\"Software Engineer\",\r\n" + //
                        "              \"job_description\":\"Develop and maintain software applications\",\r\n" + //
                        "              \"job_location\":\"New York\",\r\n" + //
                        "              \"job_salary_min\":60000.00,\r\n" + //
                        "              \"job_salary_max\":80000.00\r\n" + //
                        "          },\r\n" + //
                        "          \"employer\": {\r\n" + //
                        "              \"employer_name\":\"ABC Company\"\r\n" + //
                        "          }\r\n" + //
                        "      },\r\n" + //
                        "      {\r\n" + //
                        "          \"job\": {\r\n" + //
                        "              \"job_id\":\"2\",\r\n" + //
                        "              \"job_title\":\"Hardware Engineer\",\r\n" + //
                        "              \"job_description\":\"Develop and maintain computer hardware\",\r\n" + //
                        "              \"job_location\":\"Toronto\",\r\n" + //
                        "              \"job_salary_min\":70000.00,\r\n" + //
                        "              \"job_salary_max\":90000.00\r\n" + //
                        "          },\r\n" + //
                        "          \"employer\": {\r\n" + //
                        "              \"employer_name\":\"XYZ Company\"\r\n" + //
                        "          }\r\n" + //
                        "      },\r\n" + //
                        "      {\r\n" + //
                        "          \"job\": {\r\n" + //
                        "              \"job_id\":\"3\",\r\n" + //
                        "              \"job_title\":\"Tech Support\",\r\n" + //
                        "              \"job_description\":\"Provide technical support to users\",\r\n" + //
                        "              \"job_location\":\"Boston\",\r\n" + //
                        "              \"job_salary_min\":50000.00,\r\n" + //
                        "              \"job_salary_max\":70000.00\r\n" + //
                        "          },\r\n" + //
                        "          \"employer\": {\r\n" + //
                        "              \"employer_name\":\"123 Company\"\r\n" + //
                        "          }\r\n" + //
                        "      }\r\n" + //
                        "   ]\r\n" + //
                        "}" + //
                        "";

    }

    // template for jobs API

    @GetMapping("/jobs")
    public @ResponseBody
    Iterable<Job> getAllJobs() {
        System.out.println("Hello from getAllJobs()");
        return jobsService.allJobs();
    }

    @GetMapping("/jobs/test")
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

    @GetMapping("/jobs/{id}")
    public Job getJobInfo(@PathVariable Integer id) {
        return jobsService.getJob(id);
    }

    @GetMapping("/jobs/{id}/applies")
    public String getLink() {
        return null;
    }

    @GetMapping("/jobs/{id}/{locations}")
    public List<Job> getJobsLocation() {
        return null;
    }

    @GetMapping("/jobs/{id}/{locations}/{distances}")
    public List<Job> getJobsWithin() {
        return null;
    }

    @GetMapping("/jobs/{id}/{types}")
    public List<Job> getJobsType() {
        return null;
    }

    @GetMapping("/jobs/{id}/{wages}")
    public List<Job> getJobsWage() {
        return null;
    }

    @GetMapping("/jobs/{id}/{industries}")
    public List<Job> getJobsIndustry() {
        return null;
    }

    @GetMapping("/jobs/{id}/{companyRatings}")
    public List<Job> getJobsRating() {
        return null;
    }

    @GetMapping("/jobs/{id}/{dates}")
    public List<Job> getJobsDate() {
        return null;
    }

    @GetMapping("/jobs/{id}/{keywords}")
    public List<Job> getJobsKeyword() {
        return null;
    }

}