package com.udemy.bharath.spring.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "${jms.queue}") //from application.properties
	public void listen(String msg) {
		System.out.println(AmirMessageBuilder.compose(msg));
	}

}
