package com.udemy.bharath.spring.jms;

public class AmirMessageBuilder {

	public static String compose(String msg) {
		if (msg == null) {
			return "Message received <null>";
		}

		return String.format("Message received %s", msg);
	}
}
