package com.onlinejobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinejobportal.model.Employee;
import com.onlinejobportal.model.User;
import com.onlinejobportal.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeProfile(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByUser(User user) {
        return employeeRepository.findByUser(user);
    }
}
