package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	Car car;

	@GetMapping("/car")
	public String showCar() {
		System.out.println(car.toString());
		return car.toString();
	}

}
