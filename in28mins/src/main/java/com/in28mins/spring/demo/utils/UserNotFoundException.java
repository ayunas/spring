package com.in28mins.spring.demo.utils;

import javassist.NotFoundException;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
