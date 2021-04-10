package io.spring.testing;

import java.util.List;

public interface iEmpService {
	Employee getEmployeeByName(String name);

	List<Employee> getEmployees();
}
