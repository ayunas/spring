package io.spring.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmpService {

	@Autowired
	private EmpRepo empRepo;

	@Override
	public Employee getEmployeeByName(String name) {
		return empRepo.findByName(name);
	}

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) empRepo.findAll();
	}

}
