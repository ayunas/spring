package com.howtodoinjava.tester;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(EmployeeRESTController.class)
public class TestEmployeeController {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private iEmpRepo empRepo;

	@Test
	public void controller_returns_all_employees() throws Exception {
		RequestBuilder getReq = MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON);
		List<Employee> employees = Arrays.asList(new Employee(1L, "Amir"), new Employee(2L, "John"), new Employee(3L, "Sydney"));
		String employeesJSON = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(employees);
		System.out.println(employeesJSON);

		mvc.perform(getReq).andExpect(content().json("[{\"id\":1,\"name\":\"Amir\",\"role\":null},{\"id\":2,\"name\":\"John\",\"role\":null},{\"id\":3,\"name\":\"Sydney\",\"role\":null}]"))
				.andExpect(jsonPath("$[0].name").value("Amir"));
	}

	@Test
	public void get_by_valid_id_returns_employee() throws Exception {
		RequestBuilder getReq = MockMvcRequestBuilders.get("/employees/1").accept(MediaType.APPLICATION_JSON);
		mvc.perform(getReq).andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Amir\",\"role\":null}"));
	}

	@Test
	public void invalid_id_returns_404() throws Exception {
		RequestBuilder getReq = get("/employees/20");
		mvc.perform(getReq).andExpect(status().is(404));
	}

	@Test
	public void adding_Employee_returns_201() throws Exception {
		Employee newEmp = new Employee(5L, "jose", "janitor");
		Gson gson = new Gson();
		String empJSON = gson.toJson(newEmp);

		Mockito.when(empRepo.save(any())).thenReturn(newEmp);

		RequestBuilder postReq = MockMvcRequestBuilders
				.post("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(empJSON);

		mvc.perform(postReq).andExpect(status().is(201));
	}

	@Test
	public void adding_Employee_returns_valid_JSON() throws Exception {
		Employee newEmp = new Employee(4L, "stewart", "scientist");
		Gson gson = new Gson();
		String empJSON = gson.toJson(newEmp);

		Mockito.when(empRepo.save(any())).thenReturn(newEmp); //testing the controller as a unit, so mocking out the empRepo.
		// any() because objects are stored by reference, the exact object will not be referenced.

		RequestBuilder postReq = MockMvcRequestBuilders
				.post("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content(empJSON);

		mvc.perform(postReq).andExpect(content().string(empJSON));

	}

}
