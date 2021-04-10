package io.spring.docs.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	@Autowired
	private Address address;

	public static void main(String[] args) {
		Company company = new Company();
		System.out.println(company.address.getHouseNumber());
	}

}
