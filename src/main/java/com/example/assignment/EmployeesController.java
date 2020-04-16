package com.example.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.assignment.dto.EmployeeDetailsDTO;
import com.example.assignment.entity.Employee;
import com.example.assignment.service.EmployeeService;

@Controller
@RequestMapping(path="/employees")
public class EmployeesController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeesController.class);
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("")
	public @ResponseBody Iterable<Employee> employee() {
		Slice<Employee> pagedResult = empService.getEmployeeList();
		return pagedResult.getContent();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody EmployeeDetailsDTO employeeDetails(@PathVariable Long id, @RequestParam String token) throws Exception {
		log.debug(String.format("Employee %s details request was made", id));
		
		return empService.getEmployeeDetails(token, id);
	}
}
