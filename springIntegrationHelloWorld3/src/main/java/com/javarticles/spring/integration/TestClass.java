package com.javarticles.spring.integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {

	public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringIntegrationHelloWorldExample.class);
   Object s=context.getBean("springIntHelloWorldExample");

	}

}
