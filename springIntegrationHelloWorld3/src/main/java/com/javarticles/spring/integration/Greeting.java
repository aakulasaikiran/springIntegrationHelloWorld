package com.javarticles.spring.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;

@Configuration
public class Greeting {
	
	@Bean(name = "greeting")
	@ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
	public String sayHello(String payload) {
		System.out.println("in side sayHello() method");
		return "Hello World!" + payload;
	}
}
