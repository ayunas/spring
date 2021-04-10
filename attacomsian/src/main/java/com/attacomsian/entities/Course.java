//package com.attacomsian.entities;
//
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "course")
//public class Course {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int courseId;
//
//	private String title;
//	private String abbreviation;
//	private int modules;
//	private double fee;
//
//	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
//	private Set<Student> students = new HashSet<>();
//
//
//}
