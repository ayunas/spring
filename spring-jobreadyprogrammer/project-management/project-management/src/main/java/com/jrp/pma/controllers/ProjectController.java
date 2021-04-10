package com.jrp.pma.controllers;

import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jrp.dao.iProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired //give responsibility to spring context container to automatically create the instances. automatically create an anonymous class and give it the type of the interface.
			iProjectRepository projRepo;

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		return "new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, Model model) {
//		saves objects to the database. use redirect to prevent duplicate submissions.
		projRepo.save(project);
		return "redirect:/projects/new";
	}

}
