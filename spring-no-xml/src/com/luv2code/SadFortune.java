package com.luv2code;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sadFortune") //beanID
public class SadFortune implements Fortune {

	@Override
	public String getFortune() {
		return "Indeed sad days happen, just like happy days";
	}
}
