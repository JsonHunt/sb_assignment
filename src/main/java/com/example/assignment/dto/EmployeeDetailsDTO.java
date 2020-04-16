package com.example.assignment.dto;

import java.util.List;

import com.example.assignment.entity.Employee;
import com.example.assignment.entity.Salary;

public class EmployeeDetailsDTO {

	private long empNo;
	private String firstName;
	private String lastName;
	private String department;
	private List<Salary> salaryHistory;

	public long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Salary> getSalaryHistory() {
		return salaryHistory;
	}

	public void setSalaryHistory(List<Salary> salaryHistory) {
		this.salaryHistory = salaryHistory;
	}

	public EmployeeDetailsDTO(Employee emp, String dep, List<Salary> salaryList) {
		this.empNo = emp.getEmpNo();
		this.firstName = emp.getFirstName();
		this.lastName = emp.getLastName();
		this.department = dep;
		this.salaryHistory = salaryList;
	}

	
}
