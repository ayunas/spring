package com.pma.scratch.demo.controllers;

import com.pma.scratch.demo.entities.Employee;
import com.pma.scratch.demo.entities.Project;
import com.pma.scratch.demo.entities.Stakeholder;
import com.pma.scratch.demo.repos.iEmpRepo;
import com.pma.scratch.demo.repos.iProjectRepo;
import com.pma.scratch.demo.repos.iStakeHolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	iProjectRepo projRepo;

	@Autowired
	iEmpRepo empRepo;

	@Autowired
	iStakeHolderRepo stakeHolderRepo;

	@GetMapping
	public String showProjects(Model model) {
		System.out.println("hit the /projects endpoint");
		List<Project> projects = projRepo.findAll();
		System.out.println(projects);
		model.addAttribute("projList", projects);
		return "projects";
	}

	@GetMapping("/new")
	public String showProjectForm(Model model) {
		model.addAttribute("proj", new Project());

		List<Employee> employees = empRepo.findAll();
		model.addAttribute("empList", employees);

		List<Stakeholder> stakeholders = stakeHolderRepo.findAll();
		model.addAttribute("stakeList", stakeholders);

		return "new-project";
	}

	@PostMapping("/save")
	public String persistProject(Model model, Project proj) {
		projRepo.save(proj);

		System.out.println(proj.getEmployeeList().toString());
//
		for (Employee e : proj.getEmployeeList()) {
			e.setProject(proj);
			empRepo.save(e);
		}

		return "redirect:/projects";
		//		Employee emp1 = new Employee("amir","yunas");
//		List<Employee> employees = new ArrayList<>();
//		employees.add(emp1);
//		empRepo.save(emp1);
//		proj.setEmployeeList(employees);
	}

	@GetMapping("/test/{id}")
	public String showTestId(@PathVariable String id, Model model) {
		System.out.println("the id URL path variable is : " + id);
		return "redirect:/projects";
	}

	@GetMapping("/test/req")
	public String showReqParam(@RequestParam String data) {
		System.out.println("the request param data variable is : " + data);
		return "redirect:/projects";
	}

}
