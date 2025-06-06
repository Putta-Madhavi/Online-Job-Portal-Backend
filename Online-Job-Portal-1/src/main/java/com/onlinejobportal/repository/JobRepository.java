package com.onlinejobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinejobportal.model.Employee;
import com.onlinejobportal.model.Job;
import com.onlinejobportal.model.JobCategory;

public interface JobRepository extends JpaRepository<Job, Long> {
	
	   List<Job> findByCompany(Employee company);

	   List<Job> findByCategory(JobCategory category);

}
