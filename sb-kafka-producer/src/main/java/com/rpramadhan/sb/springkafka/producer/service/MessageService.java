package com.rpramadhan.sb.springkafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpramadhan.sb.springkafka.producer.model.Message;
import com.rpramadhan.sb.springkafka.producer.repository.MessageRepository;

@Component
public class MessageService implements IMessageService {

	@Autowired
	private MessageRepository repository;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	Logger logger = LoggerFactory.getLogger(MessageService.class);

	@Override
	public Message sendMessage(Message message) {
		
		//logically, system will store message to db first
		repository.save(message);
		
		//then publish it to kafka
		kafkaTemplate.send("sb-message", serializeMessage(message));
		
		return message;
	}
	
	private String serializeMessage(Message message) {
		String result = "";
		try {
			result = new ObjectMapper().writeValueAsString(message);
		} catch (JsonProcessingException je) {
			logger.error(je.getMessage(), je);
		}
		return result;
	}

}
