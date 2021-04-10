package com.udemy.bharath.ticketservice.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Price {
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private BigDecimal price;
}
