package com.onlinejobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinejobportal.model.JobCategory;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Long> {
	
	JobCategory findByName(String name);
	

}
