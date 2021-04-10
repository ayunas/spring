package com.howtodoinjava.tester;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loggy {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Loggy.class);
		logger.info("SLF4J works in the Tester Spring Boot App");
	}

}
