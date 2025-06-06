package com.onlinejobportal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinejobportal.model.JobCategory;
import com.onlinejobportal.repository.JobCategoryRepository;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    @Override
    public JobCategory addJobCategory(JobCategory jobCategory) {
        return jobCategoryRepository.save(jobCategory);
    }

    @Override
    public JobCategory updateJobCategory(JobCategory jobCategory) {
        return jobCategoryRepository.save(jobCategory);
    }

    @Override
    public List<JobCategory> getAllJobCategories() {
        return jobCategoryRepository.findAll();
    }

    @Override
    public void deleteJobCategory(Long id) {
        jobCategoryRepository.deleteById(id);
    }

    @Override
    public JobCategory findById(Long id) {
        return jobCategoryRepository.findById(id).orElse(null);
    }
}
