package com.jrp.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	//	mapping between the java world and the persistence world.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long projID;
	private String name;
	private String stage; //could make this an enum
	private String description;

	public Project() {
	}

	public Project(String name, String stage, String description) {
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public long getProjID() {
		return projID;
	}

	public void setProjID(long projID) {
		this.projID = projID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
