package io.spring.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private HelloController helloController;

	@MockBean
	private HelloService helloService;

	@Test
	public void sayHello() throws Exception {
		when(helloService.sayHello()).thenReturn("Hello World!");

		RequestBuilder getRequest = MockMvcRequestBuilders.get("/");
		mockMvc.perform(getRequest).andExpect(status().isOk());
	}

	@Test
	public void testHelloGreetingResponse() throws Exception {
		when(helloService.greet()).thenReturn("Hello People!"); //mocking the service
		RequestBuilder getRequest = MockMvcRequestBuilders.get("/people");
		mockMvc.perform(getRequest).andExpect(status().isOk());
	}

	@Test
	public void testHelloGreetData() throws Exception {
		when(helloController.greeting()).thenReturn("Amir");
		RequestBuilder req = MockMvcRequestBuilders.get("/people").contentType(MediaType.APPLICATION_JSON);
		MvcResult res = mockMvc.perform(req).andDo(MockMvcResultHandlers.print()).andReturn();
		String content = res.getResponse().getContentAsString();
		System.out.println(content);
//		MvcResult result = mockMvc.perform(req).andExpect(status().isOk()).andExpect(content().json("Hello My People"));
	}


}
