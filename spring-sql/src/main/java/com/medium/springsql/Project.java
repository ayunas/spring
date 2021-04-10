package com.medium.springsql;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String stage;
	private String description;

	@OneToMany(mappedBy = "project")
	private List<Employee> employees;

}
