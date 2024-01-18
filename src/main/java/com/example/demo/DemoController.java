package com.example.demo;

//Java Program to Illustrate DemoController Class 


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.kafka.core.KafkaTemplate; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController; 

//Annotation 
@RestController

//Class 
public class DemoController { 

	// Autowiring Kafka Template 
	@Autowired KafkaTemplate<String, Book> kafkaTemplate; 

	private static final String TOPIC = "NewTopic"; 

	// Annotation 
	@PostMapping("/publish") 
	public String publishMessage(@RequestBody Book book) 
	{ 
		// Sending the message 
		kafkaTemplate.send(TOPIC, book); 

		return "Published Successfully"; 
	} 
}

