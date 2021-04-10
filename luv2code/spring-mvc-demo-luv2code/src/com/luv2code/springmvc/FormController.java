package com.luv2code.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormController {

	@RequestMapping("/form")
	public String returnForm() {
		return "form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "name-page";
	}

	//controller method to read form data
	//add data to the model

	@RequestMapping("/processForm-2")
	public String letsShout(HttpServletRequest req, Model model) {
		String name = req.getParameter("studentName");

		name = name.toUpperCase();

		String result = "Yo! " + name;

		model.addAttribute("message", result);

		return "name-page";
	}

	@RequestMapping("/processForm-3")
	public String processForm3(@RequestParam("studentName") String name, Model model) {

		name = name.toUpperCase();

		String result = "v3 of processForm, saying Hi! " + name;

		model.addAttribute("message", result);

		return "name-page";
	}
}

