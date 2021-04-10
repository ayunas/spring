package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.repository.EmployeeRepo;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeRepo EmployeeRepo;
//	inject employee DAO

	@Autowired
	public EmployeeController(EmployeeRepo empDAO) {
		this.EmployeeRepo = empDAO;
	}

	//	expose '/employees and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return EmployeeRepo.findAll();
	}

//	@GetMapping("/")

//	@GetMapping("/employee/{id}")
//	public Employee findByID(@PathVariable int id) {
//		Employee emp =
//	}


//	@PostMapping("/addEmp")
//	public void addEmployee() {
//		return EmployeeRepo.save();
//	}


}
