package com.example.cis4900.spring.template.jobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer job_id;

    private String job_title;
    private String job_description;
    private String job_location;
    private float job_salaryMin;
    private float job_salaryMax;

    @JoinColumn(name = "employer_id", foreignKey = @ForeignKey(name = "employer"))
    private Integer employer_id;

    public Job(Integer job_id, String job_title, String job_description, String job_location, float job_salaryMin,
            float job_salaryMax,
            Integer employer_id) {
        this.job_id = job_id;
        this.job_title = job_title;
        this.job_description = job_description;
        this.job_location = job_location;
        this.job_salaryMin = job_salaryMin;
        this.job_salaryMax = job_salaryMax;
        this.employer_id = employer_id;
    }

    public Job() {
    }

    // Getters and setters
    public Integer getId() {
        return job_id;
    }

    public void setId(Integer id) {
        this.job_id = id;
    }

    public String getTitle() {
        return job_title;
    }

    public void setTitle(String title) {
        this.job_title = title;
    }

    public String getDescription() {
        return job_description;
    }

    public void setDescription(String description) {
        this.job_description = description;
    }

    public String getLocation() {
        return job_location;
    }

    public void setLocation(String location) {
        this.job_location = location;
    }

    public float getSalaryMin() {
        return job_salaryMin;
    }

    public void setSalaryMin(float salaryMin) {
        this.job_salaryMin = salaryMin;
    }

    public float getSalaryMax() {
        return job_salaryMax;
    }

    public void setSalaryMax(float salaryMax) {
        this.job_salaryMax = salaryMax;
    }

    public Integer getEmployerId() {
        return employer_id;
    }

    public void setEmployerId(Integer employerId) {
        this.employer_id = employerId;
    }
}
