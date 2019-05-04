package com.uditkumawat.jms.jmsdemo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	@JmsListener(destination="inmemory.queue")
	public void listener(String message) {
		
		System.out.println("Message received : "+message);
	}
}
