package com.udemy.bharath.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private iCustRepo customerRepo;

	@GetMapping
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer customerNew = customerRepo.save(customer);
		return customerNew;
	}
}
