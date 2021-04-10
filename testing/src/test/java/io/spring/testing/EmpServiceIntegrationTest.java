package io.spring.testing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EmpServiceIntegrationTest {

	@Before
	public void setUp() {
		Employee emp = new Employee("worker");
		Mockito.when(empRepo.findByName(emp.getName()))
				.thenReturn(emp);
	}

	@Test
	public void with_Valid_Name_Employee_Should_Be_Found() {
		String name = "worker";
		Employee found = employeeService.getEmployeeByName("worker");
		assertThat(found.getName())
				.isEqualTo(name);
	}

	@TestConfiguration
	static class EmpService_TestConfig {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeService();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmpRepo empRepo;

}
