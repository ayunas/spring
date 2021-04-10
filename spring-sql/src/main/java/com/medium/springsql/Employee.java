package com.medium.springsql;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
}

