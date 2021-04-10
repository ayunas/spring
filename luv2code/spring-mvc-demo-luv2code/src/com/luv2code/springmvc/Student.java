package com.luv2code.springmvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;  //used by the student-form
	private LinkedHashMap<String, String> countries;

	public Student() {
		this.countries = new LinkedHashMap<>();
		countries.put("BR", "Brazil");
		countries.put("FR", "France");
		countries.put("USA", "United States of America");
		countries.put("UK", "United Kingdom");
		countries.put("IN", "India");
	}

	public String getCountry() {
		return this.country;
	}

	public LinkedHashMap<String, String> getCountries() {
		return this.countries;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}

}
