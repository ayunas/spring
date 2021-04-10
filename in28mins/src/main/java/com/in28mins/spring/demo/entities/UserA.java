package com.in28mins.spring.demo.entities;


import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserA {
	private Integer id;
	private String name;
	private Date dob;
}
