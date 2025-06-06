package com.onlinejobportal.service;

import java.util.List;

import com.onlinejobportal.model.Job;
import com.onlinejobportal.model.JobApplication;
import com.onlinejobportal.model.User;

public interface JobApplicationService {

	JobApplication applyForJob(JobApplication jobApplication);

    List<JobApplication> getJobApplicationsByJobSeeker(User jobSeeker);

    List<JobApplication> getJobApplicationsByJob(Job job);

    List<JobApplication> getAllJobApplications();

    JobApplication updateJobApplicationStatus(Long id, JobApplication.Status status);
}