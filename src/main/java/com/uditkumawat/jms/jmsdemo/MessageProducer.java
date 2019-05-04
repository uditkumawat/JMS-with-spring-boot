package com.uditkumawat.jms.jmsdemo;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class MessageProducer {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	
	@GetMapping("/{message}")
	public String sendMessage(@PathVariable String message) {
		
		jmsTemplate.convertAndSend(queue, message);
		
		return "Message Published Successfully";
	}
}
