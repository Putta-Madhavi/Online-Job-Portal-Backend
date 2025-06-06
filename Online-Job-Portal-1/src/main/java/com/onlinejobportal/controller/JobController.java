package com.onlinejobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinejobportal.model.Employee;
import com.onlinejobportal.model.Job;
import com.onlinejobportal.model.JobCategory;
import com.onlinejobportal.service.EmployeeService;
import com.onlinejobportal.service.JobCategoryService;
import com.onlinejobportal.service.JobService;
import com.onlinejobportal.service.UserService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobCategoryService jobCategoryService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Job> addJob(@RequestBody Job job) {
        Job newJob = jobService.addJob(job);
        return ResponseEntity.ok(newJob);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Job>> getJobsByCompany(@PathVariable Long companyId) {
        Employee company = employeeService.findByUser(userService.findByUsername(companyId.toString()));
        if (company != null) {
            List<Job> jobs = jobService.getJobsByCompany(company);
            return ResponseEntity.ok(jobs);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam String keyword) {
        List<Job> jobs = jobService.searchJobs(keyword);
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Job>> getJobsByCategory(@PathVariable Long categoryId) {
        JobCategory category = jobCategoryService.findById(categoryId);
        if (category != null) {
            List<Job> jobs = jobService.getJobsByCategory(category);
            return ResponseEntity.ok(jobs);
        }
        return ResponseEntity.notFound().build();
    }
}
