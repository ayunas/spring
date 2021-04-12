package io.javabrains.sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String home() {
		return "<h1>Welcome!</h1>";
	}

	@GetMapping
	public String welcome() {
		return "<h1>Welcome! User</h1>";
	}

	@GetMapping("/user")
	public String welcomeUser() {
		return "<h1>Welcome! User</h1>";
	}


}
