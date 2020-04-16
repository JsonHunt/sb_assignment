package com.example.assignment.service;

import org.springframework.data.domain.Slice;

import com.example.assignment.dto.EmployeeDetailsDTO;
import com.example.assignment.entity.Employee;

public interface EmployeeService {

	Slice<Employee> getEmployeeList();
	EmployeeDetailsDTO getEmployeeDetails(String token, Long id);
}
