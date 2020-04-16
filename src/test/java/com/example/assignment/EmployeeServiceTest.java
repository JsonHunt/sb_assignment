package com.example.assignment;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.assignment.dao.EmployeesRepository;
import com.example.assignment.dao.SalaryRepository;
import com.example.assignment.dto.EmployeeDetailsDTO;
import com.example.assignment.entity.Employee;
import com.example.assignment.entity.Salary;
import com.example.assignment.service.EmployeeService;
import com.example.assignment.service.EmployeeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }
	
	@Autowired
    private EmployeeService employeeService;
 
    @MockBean
    private EmployeesRepository employeeRepository;
    
    @MockBean
    private SalaryRepository salaryRepository;
    
    
    @Before
    public void setUp() {
    	
    }
    
    @Test
    public void getEmployeeDetails() { 
    	Employee alex = new Employee();
        Optional<Employee> maybeAlex = Optional.of(alex);
    	alex.setFirstName("Alex");
    	
    	List<Salary> salaries = new ArrayList<Salary>();
        Mockito.when(employeeRepository.findCurrentDepartment(10001)).thenReturn("Sales");
        Mockito.when(employeeRepository.findByEmpNo(10001)).thenReturn(maybeAlex);
        Mockito.when(salaryRepository.findSalaryByEmpNo(10001)).thenReturn(salaries);
    	
    	EmployeeDetailsDTO found = employeeService.getEmployeeDetails("123123123", (long) 10001);
        assertThat(found.getFirstName()).isEqualTo("Alex");
        assertThat(found.getDepartment()).isEqualTo("Sales");
        assertThat(found.getSalaryHistory()).isEmpty();
     }
}
