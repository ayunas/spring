package io.spring.testing;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements iHelloService {
	@Override
	public String sayHello() {
		return "Hello World!";
	}

	public String greet() {
		return "Hello My People";
	}
}
