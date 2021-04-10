package com.jobreadyprogrammer.security.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	private SecurityContextHolder sec;

	public String getUserName() {
		String username = sec.getContext().getAuthentication().getName();
		return username;
	}

}
