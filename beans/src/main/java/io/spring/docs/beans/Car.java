package io.spring.docs.beans;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
	@Getter
	@Setter
	Engine e;
	@Getter
	@Setter
	Door d;
	@Getter
	@Setter
	Tire t;
}
