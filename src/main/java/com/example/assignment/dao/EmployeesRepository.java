package com.example.assignment.dao;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.example.assignment.entity.Employee;

public interface EmployeesRepository extends Repository<Employee,Long> {

	// Allows paging
	
    @Query("select e from Employee e")
    Slice<Employee> findLastEmployee(Pageable paging);
    
    Optional<Employee> findByEmpNo(long empNo);
    
    // Demonstrates use of native query syntax
    // TODO: candidate for refactoring, potential sql injection vuln (errors out on long conversion)
    
    @Query(value = "SELECT d.dept_name FROM employees.current_dept_emp as cde JOIN departments d ON d.dept_no = cde.dept_no WHERE cde.emp_no = ?1", nativeQuery = true)
    String findCurrentDepartment(long empNo);
}
