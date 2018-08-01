package com.javarticles.spring.integration;

public class Greeting {
    public String sayHello(String payload) {
        return "Hello World!" + payload;
    }
}
