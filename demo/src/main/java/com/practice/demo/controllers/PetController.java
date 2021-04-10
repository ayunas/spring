package com.practice.demo.controllers;

import com.practice.demo.entities.Pet;
import com.practice.demo.repos.iPetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pets")
public class PetController {

	@Autowired
	iPetRepo petRepo;

	@GetMapping
	public String showPetPage() {
		return "pet-page";
	}

	@GetMapping("/new")
	public String addPetForm(Model model) {
		Pet pet = new Pet();
		model.addAttribute(pet);
		return "new-pet";
	}

	@PostMapping("/save")
	public String savePet(Pet pet, Model model) {
		petRepo.save(pet);
		return "redirect:/pets/new";
	}
}
