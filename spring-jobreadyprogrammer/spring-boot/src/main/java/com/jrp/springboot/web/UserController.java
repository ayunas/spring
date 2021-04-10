package com.jrp.springboot.web;

import com.jrp.springboot.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/{userID}", method = RequestMethod.GET)
	public String displayUser(@PathVariable int userID) {
		return "User Found : " + userID;
	}

	@RequestMapping(value = "/{userID}/invoices")
	public String displayUserInvoices(@PathVariable(value = "userID") String userID, @RequestParam(value = "date", required = false) Date date) {
		return "Invoice found for user : " + userID + " on the date " + date;
	}

	@RequestMapping("/{userID}/items")
	public List<String> displayStringJSON() {
		return Arrays.asList("Shoes", "Laptop", "Button");
	}

	@RequestMapping("/{userID}/products")
	public List<Product> displayProductsJSON() {
		return Arrays.asList(new Product(1, "shoes", 100.59), new Product(2, "polo", 45));
	}

	@RequestMapping("/{prodID}/single-product")
	public Product displayProduct(@PathVariable String prodID) {
		int productID = Integer.parseInt(prodID);
		return new Product(productID, "trousers", 28.99);
	}

}
