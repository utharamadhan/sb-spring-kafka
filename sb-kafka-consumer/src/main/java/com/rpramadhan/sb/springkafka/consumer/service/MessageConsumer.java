package com.rpramadhan.sb.springkafka.consumer.service;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpramadhan.sb.springkafka.consumer.model.Message;

@Component
public class MessageConsumer {
	
	Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	
	@Autowired
	private IMessageConsumeService service;
	
	@KafkaListener(topics = "sb-message")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		service.saveMessage(deserializeMessage(cr.value().toString()));
    }

	private Message deserializeMessage(String input) {
		try {
			return new ObjectMapper().readValue(input, Message.class);
		} catch (IOException ioe) {
			logger.error(ioe.getMessage(), ioe);
		}
		return null;
	}
	
}
