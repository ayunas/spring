package com.howtodoinjava.tester;

import com.utils.EmpNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeRESTController {

	private List<Employee> employees = Arrays.asList(new Employee(1L, "Amir"), new Employee(2L, "John"), new Employee(3L, "Sydney"));
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRESTController.class);

	@Autowired
	private iEmpRepo empRepo;

	@GetMapping
	public List getAllEmployees() {
		LOGGER.info("finding products");
		System.out.println("finding products using sout");
		return this.employees;
	}

	@GetMapping("/{id}")
	public ResponseEntity getEmployeeById(@PathVariable Long id) {
		LOGGER.info("finding product by id : " + id);
		List<Employee> emp = this.employees.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		if (emp.isEmpty()) {
//			throw new EmpNotFoundException();
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found");
			return new ResponseEntity("No Employee found with that id", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(emp.iterator().next(), HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmp = empRepo.save(employee);
		return new ResponseEntity(savedEmp, HttpStatus.CREATED);
	}


}
