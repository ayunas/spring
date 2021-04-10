package io.spring.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping
	public String greeting() {
		return helloService.sayHello();
	}

	@GetMapping("/people")
	public String greetPeople() {
		return helloService.greet();
	}

}
