package com.udemy.bharath.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Coupon {
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String code;
	@Getter
	@Setter
	private BigDecimal discount;
	@Getter
	@Setter
	private String expiration;
}
