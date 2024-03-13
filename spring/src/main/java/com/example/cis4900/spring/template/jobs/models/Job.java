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
    private Integer id;

    private String title;
    private String description;
    private String location;
    private float salaryMin;
    private float salaryMax;
    
    @JoinColumn(name = "employer_id", foreignKey = @ForeignKey(name = "employer"))
    private Integer employerId;

    public Job(Integer id, String title, String description, String location, float salaryMin, float salaryMax, Integer employerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.employerId = employerId;
    }


    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(float salaryMin) {
        this.salaryMin = salaryMin;
    }

    public float getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(float salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }
}
