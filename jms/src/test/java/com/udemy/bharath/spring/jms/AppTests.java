package com.udemy.bharath.spring.jms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTests {

	@Autowired
	Sender sender;

	@Autowired
	Receiver receiver;

	@Test
	public void test_SendReceive() {
		String msg = "Hello Spring JMS!";
		sender.send(msg);
	}


	@Test
	void contextLoads() {
	}

}
