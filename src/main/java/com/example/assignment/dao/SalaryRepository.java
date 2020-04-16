package com.example.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary,Long> {

    public List<Salary> findSalaryByEmpNo(long empNo);
}
