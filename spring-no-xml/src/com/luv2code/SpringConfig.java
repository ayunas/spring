package com.luv2code;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //1. annotate the class as a Spring Configuration
@ComponentScan("com.luv2code") //2. add component scanning support
public class SpringConfig {

	//define bean for sad fortune
	@Bean
//	@Qualifier("sadFortune")
	public Fortune sadFortune() { //the method name is the beanID
		return new SadFortune();
	}

	@Bean
	public Fortune trainingFortune() {
		return new TrainingFortune();
	}


	// define bean for swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortune());
	}

	@Bean
	public Coach karateCoach() {
		return new KarateCoach();
	}

//
//	@Bean
//	public Coach chessCoach() {
//		return new ChessCoach();
//	}

}



