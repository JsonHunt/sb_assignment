package com.example.assignment;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/employees")
public class EmployeesController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;

	@GetMapping("/all")
	public @ResponseBody Iterable<Employee> employee() {
		Integer pageNo = 0;
	    Integer pageSize = 10;
	    String sortBy = "id";
	    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

	    Slice<Employee> pagedResult = employeesRepository.findLastEmployee(paging);

	    return pagedResult.getContent();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody EmployeeDetailsDTO employeeDetails(@PathVariable Long id, @RequestParam String token) throws Exception {
		Optional<Permission> p = permissionRepository.findByToken(token);
		if (p.isPresent() == false) {
			throw new Exception("You dont have permission");
		}
		long permId = p.get().getEmp_no();
		if (permId != 0 && permId != id) {
			throw new Exception("You dont have permission");
		}
		
	    Optional<Employee> emp = employeesRepository.findByEmpNo(id);
	    if (emp.isPresent()) {
	    	List<Salary> salaryHistory = salaryRepository.findSalaryByEmpNo(id);
	    	String dep = employeesRepository.findCurrentDepartment(id);
	    	EmployeeDetailsDTO dto = new EmployeeDetailsDTO(emp.get(),dep,salaryHistory);
	    	return dto;
	    }
	   
	    throw new Exception("Employee not found");
	}
}
