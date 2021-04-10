package com.udemy.bharath.ticketservice;

import com.udemy.bharath.ticketservice.dto.Price;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient("price-service")
public interface PriceAPI {
	@GetMapping("/api/prices/{id}")
	Price getPrice(@PathVariable Long id);


}
