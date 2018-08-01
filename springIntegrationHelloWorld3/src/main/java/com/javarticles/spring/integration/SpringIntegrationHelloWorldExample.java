package com.javarticles.spring.integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
@Configuration
public class SpringIntegrationHelloWorldExample {
	private MessageChannel inChannel;

	@Bean(name = "springIntHelloWorldExample")
	public Object springIntHelloWorldExample(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		try {
			SpringIntegrationHelloWorldExample springIntExample = (SpringIntegrationHelloWorldExample) context
					.getBean("springIntHelloWorldExample");

			springIntExample.post("Hi saikiran");
			
			
			QueueChannel outChannel = (QueueChannel) context.getBean("outputChannel");
			System.out.println(outChannel.receive());
			
			
		} finally {
			context.close();
		}
		return context;
	}

	public void post(String payload) {
		System.out.println("in side post method");
		Message<String> message = MessageBuilder.withPayload(payload).build();
		inChannel.send(message);
	}

	public void setInputChannel(MessageChannel in) {
		System.out.println("in side InputChannel");
		this.inChannel = in;
	}
}
