package io.spring.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class WebAppTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_Return_Default_Message() throws Exception {
//		this.mockMvc.perform.andDo().andExpect(status.isOk()).andExpect(content().string(containsString("Hello World")))
	}

}
