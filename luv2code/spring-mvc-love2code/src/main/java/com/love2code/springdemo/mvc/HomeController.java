package com.love2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //2. add the @Controller annotation
public class HomeController { //1. create a controller class

	@RequestMapping("/") // 4. add request mapping with path
	public String showMeThePage() { //3. create a controller method
		return "main-menu"; //5. return the view-name;
	}

}

