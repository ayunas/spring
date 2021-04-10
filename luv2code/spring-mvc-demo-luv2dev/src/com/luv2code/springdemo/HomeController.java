package com.luv2code.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //inherits from @Component special for Spring Web MVC. so component scanning picks this up.
public class HomeController {

	@RequestMapping("/") //method name can be anything.
	public String showHomePage() {
		return "main-menu";
	}

}
