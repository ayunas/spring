package com.luv2code.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyController {

	//	@RequestMapping("/silly-form")
//	public String displayForm() {
//		return "silly";
//	}
	@RequestMapping("/form")
	//Cannot map 'sillyController' method error, because the urlMapping is identical with the FormController
	//two solutions : change this mapping, or set up sub-mapping.
	public String displayForm() {
		return "silly";
	}
}
