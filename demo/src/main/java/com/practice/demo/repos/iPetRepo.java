package com.practice.demo.repos;

import com.practice.demo.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface iPetRepo extends CrudRepository<Pet, Integer> {
}
