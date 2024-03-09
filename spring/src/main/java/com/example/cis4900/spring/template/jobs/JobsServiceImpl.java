package com.example.cis4900.spring.template.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cis4900.spring.template.jobs.models.Job;

@Service
public class JobsServiceImpl implements JobsService {

    @Autowired
    private JobsRepository jobsRepository;

    @Override
    public String addJob(Job newJob) {
        return null;
    }

    @Override
    public Job getJob(Integer id) {
        return null;
    }

    @Override
    public String updateJob(Job updatedJob) {
        return null;
    }

    @Override
    public String deleteJob(Integer id) {
        return null;
    }

    @Override
    public Iterable<Job> allJobs() {
        System.out.println("Hello from allJobs()");
        // System.out.println("Printing jobsRepository.findAll()");
        // System.out.println(jobsRepository.findAll());
        // System.out.println("Done printing jobsRepository.findAll()");
        return jobsRepository.findAll();
    }

    @Override
    public Integer count() {
        return null;
    }
}