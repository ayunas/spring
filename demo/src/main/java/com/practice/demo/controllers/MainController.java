package com.practice.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
// == @RestController
public class MainController {

	@GetMapping("/")
	public String showIndexPage() {
		return "you must go to /pets. Nothing to see here.";
	}

}
