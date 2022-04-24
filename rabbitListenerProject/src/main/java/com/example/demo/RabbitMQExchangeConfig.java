package com.example.demo;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

	@Bean
	Exchange exampleExchange() {
		return new TopicExchange("ExampleExchange");
	}
	
	@Bean
	Exchange exampleSecondExchange() {
		return ExchangeBuilder.directExchange("ExampleSecondExchange").autoDelete().internal().build();
	}
	
	@Bean
	Exchange newExchange() {
		return ExchangeBuilder.topicExchange("TopicTestExchange")
				.autoDelete()
				.durable(true)
				.internal()
				.build();
	}
	
	@Bean
	Exchange fanoutExchange() {
		return ExchangeBuilder.fanoutExchange("FanoutTestExchange")
				.autoDelete()
				.durable(false)
				.internal()
				.build();
	}
	
	@Bean
	Exchange headersExchange() {
		return ExchangeBuilder.headersExchange("HeadersTestExchange")
				.durable(true)
				.internal()
				.ignoreDeclarationExceptions()
				.build();
	}
}
