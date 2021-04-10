//package com.attacomsian.entities;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name="student")
//public class Student {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	private String name;
//	private int age;
//	private String grade;
//
//	@ManyToMany(fetch = FetchType.LAZY,
//				cascade = CascadeType.PERSIST)
//	@JoinTable(
//		name = "students_courses",
//		joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false, updatable = false)},
//		inverseJoinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)}
//	)
//	private Set<Course> courses = new HashSet<>();
//
//}
