package com.example.assignment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long> {

    public List<Salary> findSalaryByEmpNo(long empNo);
}
