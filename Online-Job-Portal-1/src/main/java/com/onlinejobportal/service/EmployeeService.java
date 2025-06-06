package com.onlinejobportal.service;

import com.onlinejobportal.model.Employee;
import com.onlinejobportal.model.User;

public interface EmployeeService {

	Employee registerEmployee(Employee employee);

    Employee updateEmployeeProfile(Employee employee);

    Employee findByUser(User user);
}