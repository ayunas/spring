package io.spring.testing;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.client.match.JsonPathRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static javax.swing.UIManager.get;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmpController.class)
public class EmpController_IntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService empService;

	@Test
	public void with_Employees_when_Getting_Employees_Then_Return_Employees() throws Exception {
		Employee alex = new Employee("alex");
		List<Employee> employees = Arrays.asList(alex);


//		MockMvc mockMVC = MockMvcBuilders.standaloneSetup();


//		given(empService.getEmployees()).willReturn(employees);

		MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/api/employees").contentType(MediaType.APPLICATION_JSON);

		mvc.perform(getRequest).andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$", hasSize(1))).andExpect((ResultMatcher) jsonPath("$[0].name", is(alex.getName())));


//		mvc.perform(getRequest).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].name", is(alex.getName())));
//
//		StatusResultMatchers status = status();
//		ResultMatcher okStatus = status.isOk();
//		Matcher sizeOne = hasSize(1);
//		Matcher nameIsAlex = is(alex.getName());
//
//		RequestMatcher jsonOne = jsonPath("$", sizeOne);
//		RequestMatcher nameJSON = jsonPath("$[0].name", nameIsAlex);

//		mvc.perform(get("/api/employees")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$", hasSize(1)))
//				.andExpect(jsonPath("$[0].name", is(alex.getName())));

//		mvc.perform(getRequest)
//				.andExpect(okStatus)
//				.andExpect((ResultMatcher) jsonOne)
//				.andExpect((ResultMatcher) nameJSON);
	}

}
