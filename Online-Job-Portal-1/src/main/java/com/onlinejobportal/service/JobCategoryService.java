package com.onlinejobportal.service;

import java.util.List;

import com.onlinejobportal.model.JobCategory;

public interface JobCategoryService {
	
	JobCategory addJobCategory(JobCategory jobCategory);


    JobCategory updateJobCategory(JobCategory jobCategory);

    
    List<JobCategory> getAllJobCategories();

    void deleteJobCategory(Long id);

    JobCategory findById(Long id);
}