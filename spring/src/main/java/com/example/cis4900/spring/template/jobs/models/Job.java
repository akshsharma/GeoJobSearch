package com.example.cis4900.spring.template.jobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    private String job_title;
    private String job_description;
    private String job_location;
    private float job_salaryMin;
    private float job_salaryMax;
    private String job_website_link;
    private String job_application_link;

    @JoinColumn(name = "employer_id", foreignKey = @ForeignKey(name = "employer"))
    private Integer employer_id;

    public Job(Integer jobId, String job_title, String job_description, String job_location, float job_salaryMin,
            float job_salaryMax,
            Integer employer_id,
            String job_website_link,
            String job_application_link) {
        this.jobId = jobId;
        this.job_title = job_title;
        this.job_description = job_description;
        this.job_location = job_location;
        this.job_salaryMin = job_salaryMin;
        this.job_salaryMax = job_salaryMax;
        this.employer_id = employer_id;
        this.job_website_link = job_website_link;
        this.job_application_link = job_application_link;
    }

    public Job() {
    }

    // Getters and setters
    public Integer getId() {
        return jobId;
    }

    public void setId(Integer id) {
        this.jobId = id;
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

    public String getWebsiteLink() {
        return job_website_link;
    }

    public void setWebsiteLink(String website_link) {
        this.job_website_link = website_link;
    }

    public String getApplicationLink() {
        return job_application_link;
    }

    public void setApplicationLink(String application_link) {
        this.job_application_link = application_link;
    }
}
