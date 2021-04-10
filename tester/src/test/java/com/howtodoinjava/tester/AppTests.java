package com.howtodoinjava.tester;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests {

	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	void contextLoads() {
		System.out.println(this.baseURL);
	}

}
