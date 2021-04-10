package com.udemy.bharath.spring.jms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AmirMessageBuilderTests {

	@Test
	public void smoke() {
		String msg = "test message for AmirMessageBuilder";
		String expected = String.format("Message received %m", msg);
		;
		String actual = AmirMessageBuilder.compose(msg);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void nullMessage() {
		String msg = null;
		String expected = String.format("Message received %s", "<null>");
		String actual = AmirMessageBuilder.compose(msg);
		Assertions.assertEquals(expected, actual);
	}

}
