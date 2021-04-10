package com.example.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Component
public class Car {
	Engine e;
	Door d;
	Tire t;
}
