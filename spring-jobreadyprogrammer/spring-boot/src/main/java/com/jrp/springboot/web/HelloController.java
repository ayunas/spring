package com.jrp.springboot.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String helloSpring() {
		return "I'ts working! <a href=\"/form\">Go To Form</a><br/>";
	}

	@RequestMapping(value = "/form")
	public String displayForm() {
		return "<form action=\"/done-form\" method=\"get\">\n" +
				"  <label for=\"fname\">First name:</label><br>\n" +
				"  <input type=\"text\" id=\"fname\" name=\"fname\" value=\"John\"><br>\n" +
				"  <label for=\"lname\">Last name:</label><br>\n" +
				"  <input type=\"text\" id=\"lname\" name=\"lname\" value=\"Doe\"><br><br>\n" +
				"  <input type=\"submit\" value=\"Submit\">\n" +
				"</form>";
	}

	@RequestMapping(value = "/done-form", method = RequestMethod.GET)
	public String showFormSubmission(@RequestParam String fname, @RequestParam String lname) {
		return "Welcome! " + fname + " " + lname;
	}

	@RequestMapping("/orders/{id}")
	public String processOrderID(@PathVariable String id) {
		return "Order ID : " + id;
	}


}

