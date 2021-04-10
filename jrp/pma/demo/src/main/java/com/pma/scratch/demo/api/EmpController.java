package com.pma.scratch.demo.api;

import com.pma.scratch.demo.entities.Employee;
import com.pma.scratch.demo.repos.iEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpController {

	@Autowired
	iEmpRepo empRepo;

	@GetMapping
	public List<Employee> showEmployees() {
		return empRepo.findAll();
	}

	@GetMapping(params = {"page", "size"})
	public ResponseEntity<Employee> showEmployeePage(@RequestParam int page, @RequestParam int size) {
		Pageable pageAndSize = PageRequest.of(page, size);
		Page<Employee> empPage = empRepo.findAll(pageAndSize);
		return new ResponseEntity(empPage, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Employee sendEmployee(@PathVariable Long id) {
		return empRepo.findById(id).get(); //findById() returns in Optional<Employee>
	}

	@PostMapping(consumes = "application/json") //consumes is not required
	@ResponseStatus(HttpStatus.CREATED)
	public Employee postEmployee(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}

//	@PutMapping(path = "/{id}")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public Employee replaceEmployee(@RequestBody Employee emp) {
//		return empRepo.save(emp);
////		the correct id needs to be in the body, or this method should update the idea correctly.
//	}

	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee empReq) {
		empReq.getFirstName();
		Employee employee = empRepo.findById(id).get();

		String firstName = empReq.getFirstName();
		String lastName = empReq.getLastName();

		if (firstName.length() > 0) {
			employee.setFirstName(empReq.getFirstName());
		}

		if (lastName != null) {
			employee.setLastName(empReq.getLastName());
		}
		return empRepo.save(employee);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteEmployee(@PathVariable("id") long id) {
		try {
			empRepo.deleteById(id);
			return "Employee with id " + id + " deleted successfully";
		} catch (EmptyResultDataAccessException e) {
			return "Error : " + e + " Employee was not found in the database";
		}
	}
}
