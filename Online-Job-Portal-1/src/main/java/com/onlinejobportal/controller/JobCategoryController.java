package com.onlinejobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinejobportal.model.JobCategory;
import com.onlinejobportal.service.JobCategoryService;

@RestController
@RequestMapping("/api/job-categories")
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @PostMapping
    public ResponseEntity<JobCategory> addJobCategory(@RequestBody JobCategory jobCategory) {
        JobCategory newJobCategory = jobCategoryService.addJobCategory(jobCategory);
        return ResponseEntity.ok(newJobCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobCategory> updateJobCategory(@PathVariable Long id, @RequestBody JobCategory jobCategory) {
        jobCategory.setId(id);
        JobCategory updatedJobCategory = jobCategoryService.updateJobCategory(jobCategory);
        return ResponseEntity.ok(updatedJobCategory);
    }

    @GetMapping
    public ResponseEntity<List<JobCategory>> getAllJobCategories() {
        List<JobCategory> jobCategories = jobCategoryService.getAllJobCategories();
        return ResponseEntity.ok(jobCategories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobCategory(@PathVariable Long id) {
        jobCategoryService.deleteJobCategory(id);
        return ResponseEntity.noContent().build();
    }
}
