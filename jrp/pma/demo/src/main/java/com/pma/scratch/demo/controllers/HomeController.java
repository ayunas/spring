package com.pma.scratch.demo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pma.scratch.demo.dto.ProjectStages;
import com.pma.scratch.demo.dto.ProjectStakes;
import com.pma.scratch.demo.entities.Employee;
import com.pma.scratch.demo.repos.iEmpRepo;
import com.pma.scratch.demo.repos.iProjectRepo;
import com.pma.scratch.demo.repos.iStakeHolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	iStakeHolderRepo stakeHolderRepo;

	@Autowired
	iProjectRepo projectRepo;

	@GetMapping
	public String showHome(Model model) throws JsonProcessingException {
//		List<ProjectStakes> projectStakes = stakeHolderRepo.findStakeholdersOnProjects();
		List<ProjectStages> projectStages = projectRepo.showProjectStages();
//		model.addAttribute("projectStakes",projectStakes);
		model.addAttribute("projectStages", projectStages);

		ObjectMapper objMapper = new ObjectMapper();
		String stageJSON = objMapper.writeValueAsString(projectStages);
		model.addAttribute("stageJSON", stageJSON);

		return "home";
	}

}
