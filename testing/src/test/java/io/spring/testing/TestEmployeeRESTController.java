package io.spring.testing;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(EmployeeRESTController.class)
public class TestEmployeeRESTController {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getEmployees() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/emps").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
//				.andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());

	}

}
