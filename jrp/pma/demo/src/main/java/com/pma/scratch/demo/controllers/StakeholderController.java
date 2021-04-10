package com.pma.scratch.demo.controllers;

import com.pma.scratch.demo.entities.Project;
import com.pma.scratch.demo.entities.Stakeholder;
import com.pma.scratch.demo.repos.iProjectRepo;
import com.pma.scratch.demo.repos.iStakeHolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stakeholders")
public class StakeholderController {

	@Autowired
	iStakeHolderRepo stakeRepo;

	@Autowired
	iProjectRepo projRepo;

	@GetMapping
	public String showStakeholders(Model model) {
		List<Stakeholder> stakeholders = stakeRepo.findAll();
		model.addAttribute("stakeholders", stakeholders);
		return "stakeholders";
	}

	@GetMapping("/new")
	public String addStakeholder(Model model) {
		System.out.println("made it to /stakeholders/new");
		model.addAttribute("stakeholder", new Stakeholder());

		List<Project> projects = projRepo.findAll();
		model.addAttribute("projects", projects);
		return "new-stakeholder";
	}

	@PostMapping("/save")
	public String persistStakeholder(Stakeholder sh) {
		stakeRepo.save(sh);
		return "redirect:/stakeholders";
	}
}
