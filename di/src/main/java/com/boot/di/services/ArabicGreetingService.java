package com.boot.di.services;

import org.springframework.stereotype.Service;

//@Service
public class ArabicGreetingService implements GreetingService {

	@Override
	public String greet() {
		return "السلام عليكم.  أهلا و سهلا.  مرحبا بكم في تطبيقنا هذا";
	}

}
