package com.howtodoinjava.tester;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@WebMvcTest(HelloController.class)
public class TestHello {

	@Autowired
	MockMvc mvc;

	@Test
	public void invalidURL() throws Exception {
		RequestBuilder getReq = MockMvcRequestBuilders.get("/cool").accept(MediaType.APPLICATION_JSON);
		mvc.perform(getReq).andExpect(MockMvcResultMatchers.status().is(404)).andDo(print());
	}

	@Test
	public void validURL() throws Exception {
		RequestBuilder getReq = MockMvcRequestBuilders.get("/").contentType(MediaType.APPLICATION_JSON);
		mvc.perform(getReq).andExpect(status().is(200));
	}

	@Test
	public void check_if_Hello_World_is_returned() throws Exception {
		RequestBuilder getReq = MockMvcRequestBuilders.get("/");
//		Matcher<String> helloString = Matchers.containsString("Hello World");

		mvc.perform(getReq).andExpect(content().string("Hello World"));
	}
}
