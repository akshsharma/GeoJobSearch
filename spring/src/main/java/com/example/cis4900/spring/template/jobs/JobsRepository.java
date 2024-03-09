package com.example.cis4900.spring.template.jobs;

import com.example.cis4900.spring.template.jobs.models.Job;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends CrudRepository<Job, Long> {

    // Inherits CRUD operations and query methods for handling 'Job' entities.

}