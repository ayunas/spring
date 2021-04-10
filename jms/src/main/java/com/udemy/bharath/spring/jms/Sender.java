package com.udemy.bharath.spring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${jms.queue}")
	private String queue;

	public void send(String msg) {

		jmsTemplate.convertAndSend(queue, msg);

		MessageCreator message = m -> m.createTextMessage("Hello Spring JMS!");
		jmsTemplate.send(queue, message);
	}
}
