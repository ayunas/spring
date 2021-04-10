package com.pma.scratch.demo.services;

import com.pma.scratch.demo.entities.Stakeholder;
import com.pma.scratch.demo.repos.iStakeHolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StakeholderService {

	@Autowired
	iStakeHolderRepo stakeholderRepo;

	public Stakeholder updateFullName(long id, Stakeholder shReq) {
		System.out.println("in updateFullName()" + shReq.toString());
		System.out.println(id);
		Optional<Stakeholder> possibleStakeholder = stakeholderRepo.findById(id);
		if (possibleStakeholder.isPresent()) {
			Stakeholder stakeholder = possibleStakeholder.get();
			stakeholder.setFirstName(shReq.getFirstName());
			stakeholder.setLastName(shReq.getLastName());
			return stakeholderRepo.save(stakeholder);
		}

		if (stakeholderRepo.findById(id).isEmpty()) {
			return null;
		}

		return stakeholderRepo.findById(id).get();

	}
}
