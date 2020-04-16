package com.example.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.assignment.dao.EmployeesRepository;
import com.example.assignment.dao.PermissionRepository;
import com.example.assignment.dao.SalaryRepository;
import com.example.assignment.dto.EmployeeDetailsDTO;
import com.example.assignment.entity.Employee;
import com.example.assignment.entity.Permission;
import com.example.assignment.entity.Salary;
import com.example.assignment.error.InvalidRequestError;
import com.example.assignment.error.PermissionError;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public Slice<Employee> getEmployeeList() {
		
		// TODO: for now hard-coded to show first 10 records
		Integer pageNo = 0;
	    Integer pageSize = 10;
	    String sortBy = "id";
	    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

	    return employeesRepository.findLastEmployee(paging);
	}
	
	public EmployeeDetailsDTO getEmployeeDetails(String token, Long id) {
		if (id == null || token == null) {
			throw new InvalidRequestError();
		}
		
		Optional<Permission> p = permissionRepository.findByToken(token);
		if (p.isPresent() == false) {
			throw new PermissionError(token,id);
		}
		long permId = p.get().getEmp_no();
		if (permId != 0 && permId != id) {
			throw new PermissionError(token,id);
		}
		
	    Optional<Employee> emp = employeesRepository.findByEmpNo(id);
	    if (emp.isPresent()) {
	    	List<Salary> salaryHistory = salaryRepository.findSalaryByEmpNo(id);
	    	String dep = employeesRepository.findCurrentDepartment(id);
	    	EmployeeDetailsDTO dto = new EmployeeDetailsDTO(emp.get(),dep,salaryHistory);
	    	return dto;
	    }
	    else {
	    	throw new InvalidRequestError();
	    }
	}
}
