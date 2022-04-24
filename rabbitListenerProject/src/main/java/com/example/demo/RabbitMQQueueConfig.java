package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfig {

	@Bean
	Queue exampleQueue() {
		return new Queue("ExampleQueue", false);
	}
	
	@Bean
	Queue exampleSecondQueue() {
		return QueueBuilder.durable("ExampleSecondQueue")
				.autoDelete()
				.exclusive()
				.build();
	}
}
