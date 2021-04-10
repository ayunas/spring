package io.spring.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(EmpController.class)
public class EmpControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmpRepo empRepo;

	@MockBean
	private EmpController empController;

	@Test
	public void testFindAll() throws Exception {
		Employee rod = new Employee("rod");
		Employee danny = new Employee("danny");

		List<Employee> employees = Arrays.asList(rod, danny);

		//mock the call to the database using mockito
		when(empRepo.findAll()).thenReturn(employees);

		RequestBuilder getRequest = MockMvcRequestBuilders.get("/api/employees").contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(getRequest).andExpect(status().is(200)).andExpect(content().json("[{'id':1,name:'rod'},{'id':2,name:'danny'}]"));

	}

	@Test
	public void test() {
		assert (1 == 1);
	}

}
