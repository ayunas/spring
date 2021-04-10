package com.jobreadyprogrammer.pagination.entities;

import com.jobreadyprogrammer.pagination.config.ProjectData;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
@Getter @Setter
public class Project {
	@Id @GeneratedValue
	private int id;
	private String name;
	private String stage;
	private String deccription;
}
