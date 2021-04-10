package com.howtodoinjava.tester;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	@NonNull
	private Long id;
	@Getter
	@Setter
	@NonNull
	private String name;
	@Getter
	@Setter
	private String role;

	public static void main(String[] args) {
		Employee emp = new Employee();
		System.out.println(emp.id);
	}
}