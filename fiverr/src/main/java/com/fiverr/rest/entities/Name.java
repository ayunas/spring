package com.fiverr.rest.entities;

import javax.persistence.*;

@Entity
@Table(name = "name")
public class Name {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	public Name() {
	}

	public Name(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

}
