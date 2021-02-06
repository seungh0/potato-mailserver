package com.potato.config;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver;

import java.util.Collections;

@Configuration
public class SqsConfig {

	@Bean
	public QueueMessageHandlerFactory queueMessageHandlerFactory(final AmazonSQSAsync amazonSQSAsync, final ObjectMapper objectMapper) {
		final QueueMessageHandlerFactory queueMessageHandlerFactory = new QueueMessageHandlerFactory();
		queueMessageHandlerFactory.setArgumentResolvers(Collections.singletonList(
				new PayloadMethodArgumentResolver(jackson2MessageConverter(objectMapper)))
		);
		queueMessageHandlerFactory.setAmazonSqs(amazonSQSAsync);
		return queueMessageHandlerFactory;
	}

	private MappingJackson2MessageConverter jackson2MessageConverter(final ObjectMapper objectMapper) {
		final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setObjectMapper(objectMapper);
		return converter;
	}

}
