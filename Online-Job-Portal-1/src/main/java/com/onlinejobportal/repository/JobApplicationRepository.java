package com.onlinejobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinejobportal.model.Job;
import com.onlinejobportal.model.JobApplication;
import com.onlinejobportal.model.User;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

	  List<JobApplication> findByJobSeeker(User jobSeeker);

	  List<JobApplication> findByJob(Job job);
}
