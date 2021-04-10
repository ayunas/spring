package com.spring.decorate.entities;

import com.spring.decorate.annotations.JsonField;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
	@Id
	@GeneratedValue
	@Getter
	private String id;

	@NotNull
	@JsonField(value = "manufacturer")
	@Getter
	@Setter
	private String make;

	@JsonField
	@Getter
	@Setter
	private String model;
	@Getter
	@Setter
	private String year;
}
