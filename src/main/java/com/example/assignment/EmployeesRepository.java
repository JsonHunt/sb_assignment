package com.example.assignment;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeesRepository extends JpaRepository<Employee,Long>, PagingAndSortingRepository<Employee,Long>{

    @Query("select e from Employee e")
    Slice<Employee> findLastEmployee(Pageable paging);
    
    Optional<Employee> findByEmpNo(long empNo);
    
    @Query(value = "SELECT d.dept_name FROM employees.current_dept_emp as cde JOIN departments d ON d.dept_no = cde.dept_no WHERE cde.emp_no = ?1", nativeQuery = true)
    String findCurrentDepartment(long empNo);
}
