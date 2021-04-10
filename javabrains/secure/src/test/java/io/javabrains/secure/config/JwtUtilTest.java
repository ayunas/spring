package io.javabrains.secure.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

	@Autowired
	JwtUtil jwtUtil;

	@Test
	public void hrsToMillis() {
		long expected = 36000000;
		long actual = new JwtUtil().hrsToMillis(10);
		assertEquals(expected,actual);
	}

}