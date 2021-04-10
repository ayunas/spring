package com.howtodoinjava.tester;

import javassist.NotFoundException;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	iProdRepo prodRepo;

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping
	public ResponseEntity getProducts() {
		Iterable<Product> products = prodRepo.findAll();
		return new ResponseEntity(products, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity getProductById(@PathVariable Long id) {

		System.out.println(id);
		logger.info("getting a product by id : {}", id);

		Optional<Product> prod = prodRepo.findById(id);

		if (prod.isEmpty()) {
			return new ResponseEntity("product with id : " + id + " not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(prod, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity addProduct(@RequestBody Product prod) {
		try {
			Product savedProd = prodRepo.save(prod);
			return new ResponseEntity(savedProd, HttpStatus.CREATED);
		} catch (PersistenceException pe) {
			return new ResponseEntity(pe, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product prod) {

		Optional<Product> aProduct = prodRepo.findById(id);
		if (aProduct.isEmpty()) {
			return new ResponseEntity("No product with id : " + id + " found", HttpStatus.NOT_FOUND);
		}

		Product retrievedProduct = aProduct.get();

		String newName = prod.getName();
		BigDecimal newPrice = prod.getPrice();
		String newDescription = prod.getDescription();
		retrievedProduct.setName(newName);
		retrievedProduct.setPrice(newPrice);
		retrievedProduct.setDescription(newDescription);

		prodRepo.save(retrievedProduct);

		return new ResponseEntity(retrievedProduct, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {

//		if(prodRepo.findById(id).isEmpty()) {
//			return new ResponseEntity("no product with id " + id + " found", HttpStatus.NOT_FOUND);
//		}
		prodRepo.deleteById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
