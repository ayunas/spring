package com.pma.scratch.demo.controllers;

import com.pma.scratch.demo.entities.Employee;
import com.pma.scratch.demo.repos.iEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	iEmpRepo empRepo;

	@GetMapping
	public String showEmployees(Model model) {
		List<Employee> employeeList = empRepo.findAll();
		model.addAttribute("empList", employeeList);
		return "employees";
	}

	@GetMapping("/new")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new-employee";
	}

	@PostMapping("/save")
	public String persistEmploye(Employee employee) {
		empRepo.save(employee);
		return "redirect:/employees";
	}


}
