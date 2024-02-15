package com.example.cis4900.spring.template.jobs;

import com.example.cis4900.spring.template.jobs.models.Job;
import com.example.cis4900.spring.template.jobs.models.Employer;

public class JobsServiceImpl implements JobsService {
    
    @Autowired
    private JobsDao jobsDao;

    @Override
    public String addJob(Job newJob) {
        try {
            jobsDao.save(newJob);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Saved";
    }

    @Override
    public Job getJob(Integer id) {
        return jobsDao.findById(id).orElse(null);  // Using orElse(null) to handle the case where the job is not found.
    }

    @Override
    public String updateJob(Job updatedJob) {
        try {
            jobsDao.save(updatedJob);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Updated";
    }

    @Override
    public String deleteJob(Integer id) {
        try {
            jobsDao.deleteById(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Deleted";
    }

    @Override
    public Iterable<Job> allJobs() {
        return jobsDao.findAll();
    }

    @Override
    public Integer count() {
        return jobsDao.getCount();  // Assuming there's a getCount() method in JobsDao similar to NotesDao.
    }
}