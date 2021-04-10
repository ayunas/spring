package com.udemy.bharath.priceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

	@Autowired
	iPriceRepo priceRepo;

	//	Get Prices
	@GetMapping
	public List<Price> getPrices() {
		return priceRepo.findAll();
	}


	//	Get One Price
	@GetMapping("/{id}")
	public ResponseEntity<Price> getPrice(@PathVariable Long id) {
		Optional<Price> price = priceRepo.findById(id);
		if (price.isEmpty()) {
			return new ResponseEntity("No Price found with id : " + Long.toString(id), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(price, HttpStatus.OK);
	}

	@PostMapping
	public Price addPrice(@RequestBody Price newPrice) {
		return priceRepo.save(newPrice);
	}


//	Add a Price


}
