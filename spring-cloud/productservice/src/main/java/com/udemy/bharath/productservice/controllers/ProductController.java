package com.udemy.bharath.productservice.controllers;

import com.udemy.bharath.productservice.dao.ProductRepo;
import com.udemy.bharath.productservice.dto.Coupon;
import com.udemy.bharath.productservice.entities.Product;
import com.udemy.bharath.productservice.restclients.CouponClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CouponClient couponClient;

	@GetMapping
	public Iterable<Product> getProducts() {
		System.out.println("in getProducts()");
		Iterable<Product> products = productRepo.findAll();
		products.forEach(p -> System.out.println(p));
		return products;
	}

	@GetMapping("/{name}")
	public Product getProductByName(@PathVariable String name) {
		System.out.println("product name : " + name);
		Product prod = productRepo.findByName(name);
		System.out.println(prod.toString());
		return prod;
	}

	@PostMapping
	public Product addProduct(@RequestBody Product prod) {
//		get the coupon from the new product.
//		subtract the value from the price of the product.
//		update the price and then save it in the database
		System.out.println("product in addProduct() " + prod.toString());
		String code = prod.getCouponCode();
		Coupon coupon = couponClient.getCoupon(code);
		BigDecimal discount = coupon.getDiscount();
		BigDecimal lowerPrice = prod.getPrice().subtract(discount);
		prod.setPrice(lowerPrice);
		System.out.println("coupon : " + coupon.toString());
		System.out.println("discount : " + discount);
		System.out.println("lowerPrice : " + lowerPrice);
		return productRepo.save(prod);
	}

	@GetMapping("/coupons")
	public List<Coupon> getCoupons() {
		System.out.println("in getCoupons() of ProductController");
		List<Coupon> coupons = couponClient.getCoupons();
		return coupons;
	}
}
