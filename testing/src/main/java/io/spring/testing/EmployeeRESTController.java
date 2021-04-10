package io.spring.testing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeRESTController {

	@GetMapping("/emps")
	public List<Employee> getEmployees() {
		return Arrays.asList(new Employee("don"), new Employee("jimmy"));
	}

	@GetMapping("/emps/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		Employee test = new Employee("junior");
		return test;
	}


}
