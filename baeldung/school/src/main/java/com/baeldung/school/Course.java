package com.baeldung.school;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(mappedBy = "likedCourses", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Student> studentLikes;

	private String name;

	public Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Student> getStudentLikes() {
		return studentLikes;
	}

	public void setStudentLikes(List<Student> studentLikes) {
		this.studentLikes = studentLikes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void likeCourse(Student student) {
		this.studentLikes.add(student);
	}

}