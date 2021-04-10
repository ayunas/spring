package com.pma.scratch.demo.api;

import com.pma.scratch.demo.entities.Stakeholder;
import com.pma.scratch.demo.repos.iStakeHolderRepo;
import com.pma.scratch.demo.services.StakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stakeholders")
public class StakeRestController {

	@Autowired
	iStakeHolderRepo stakeRepo;

	@Autowired
	StakeholderService stakeService;

	@GetMapping
	public ResponseEntity<Stakeholder> getStakeholders() {
		List<Stakeholder> stakes = stakeRepo.findAll();
		return new ResponseEntity(stakes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Stakeholder> getAStakeHolder(@PathVariable long id) {
		Optional<Stakeholder> stakeholder = stakeRepo.findById(id);
		if (stakeholder.isEmpty()) {
			return new ResponseEntity("No Stakeholder with that id found", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(stakeholder.get(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Stakeholder> addStakeHolder(@RequestBody Stakeholder person) {
		Stakeholder staker = stakeRepo.save(person);
		return new ResponseEntity<>(staker, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Stakeholder> updateStakeholder(@PathVariable long id, @RequestBody Stakeholder person) {
//
//		return new ResponseEntity(updatedStakeholder,HttpStatus.ACCEPTED);

		System.out.println(id);
		System.out.println(person.toString());
		Stakeholder updatedStakeholder = stakeService.updateFullName(id, person);

		if (updatedStakeholder == null) {
			return new ResponseEntity("id " + Long.toString(id) + " not found in the database ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(updatedStakeholder, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStakeholder(@PathVariable long id) {
		stakeRepo.deleteById(id);
		return new ResponseEntity("Removed Stakeholder with id : " + Long.toString(id) + " ", HttpStatus.NO_CONTENT);
	}
}
