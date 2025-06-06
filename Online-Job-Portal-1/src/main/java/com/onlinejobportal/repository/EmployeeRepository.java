package com.onlinejobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinejobportal.model.Employee;
import com.onlinejobportal.model.User;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByUser(User user);

}
