package com.javarticles.spring.integration;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class SpringIntegrationHelloWorldExample {
    private MessageChannel inChannel;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        try {
            SpringIntegrationHelloWorldExample springIntExample = (SpringIntegrationHelloWorldExample) context
                    .getBean("springIntHelloWorldExample");
          
            springIntExample.post("Hi saikiran");
            System.out.println("hhhhhhh");
            //springIntExample.post("This is spring integration example.");
           /* Object inChannel = context.getBean("inputChannel");
            System.out.println(inChannel.hashCode());
            System.out.println(inChannel.toString());
            System.out.println(inChannel.getClass());*/
            
          /* System.out.println();*/
            QueueChannel outChannel = (QueueChannel) context.getBean("outputChannel");
            System.out.println(outChannel.receive());
            System.out.println(outChannel.hashCode());
            System.out.println(outChannel.toString());
            System.out.println(outChannel.getClass());
            /* System.out.println(outChannel.getQueueSize());
            System.out.println(outChannel.getRemainingCapacity());
            System.out.println(outChannel.hashCode());
            System.out.println(outChannel.toString());
            System.out.println(outChannel.INDEFINITE_TIMEOUT);
            System.out.println(outChannel.getClass());*/
        } finally {
            context.close();
        }
    }

    public void post(String payload) {
        Message<String> message = MessageBuilder.withPayload(payload).build();
        inChannel.send(message);
    }

    public void setInputChannel(MessageChannel in) {
        this.inChannel = in;
    }
}
