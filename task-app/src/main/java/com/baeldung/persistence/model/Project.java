package com.baeldung.persistence.model;

import java.time.LocalDate;

public class Project {

	private long id; //why do Long?
	private String name;
	private LocalDate dateCreated;

	public Project(long id, String name, LocalDate dateCreated) {
		this.id = id;
		this.name = name;
		this.dateCreated = dateCreated;
	}

	public Project(Project project) {  //create another constructor that accepts an input project.  and feed it into the fully fledged constructor to populate all the properties.
		this(project.getId(), project.getName(), project.getDateCreated());
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public LocalDate getDateCreated() {
		return this.dateCreated;
	}

	public void setId(long Id) {
		this.id = Id;
	}

	public void setName(String nm) {
		this.name = nm;
	}

	public void setDateCreated(LocalDate date) {
		this.dateCreated = date;
	}

}
