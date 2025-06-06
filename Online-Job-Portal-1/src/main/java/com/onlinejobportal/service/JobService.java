package com.onlinejobportal.service;

import java.util.List;
import java.util.Optional;

import com.onlinejobportal.model.Employee;
import com.onlinejobportal.model.Job;
import com.onlinejobportal.model.JobCategory;

public interface JobService {
    Job addJob(Job job);

    List<Job> getJobsByCompany(Employee company);

    List<Job> getAllJobs();

    List<Job> searchJobs(String keyword);

    List<Job> getJobsByCategory(JobCategory category);

    Optional<Job> findById(Long id);  }
