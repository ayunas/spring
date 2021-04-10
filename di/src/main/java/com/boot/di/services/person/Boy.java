package com.boot.di.services.person;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class Boy implements Person {

	@Override
	public String talk() {
		return "let's play ball";
	}
}
