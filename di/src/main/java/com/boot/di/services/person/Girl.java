package com.boot.di.services.person;

import org.springframework.stereotype.Service;

@Service
public class Girl implements Person {
	@Override
	public String talk() {
		return "let's play with dolls";
	}
}
