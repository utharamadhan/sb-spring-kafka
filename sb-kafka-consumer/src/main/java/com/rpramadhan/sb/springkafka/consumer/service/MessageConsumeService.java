package com.rpramadhan.sb.springkafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rpramadhan.sb.springkafka.consumer.model.Message;
import com.rpramadhan.sb.springkafka.consumer.repository.MessageRepository;

@Component
public class MessageConsumeService implements IMessageConsumeService {

	@Autowired
	private MessageRepository repository;
	
	@Value("${sb.consumer.app.id:NAN}")
	private String appId;
	
	Logger logger = LoggerFactory.getLogger(MessageConsumeService.class);

	@Override
	public Message saveMessage(Message message) {
		return repository.save(setAppId(message));
	}
	
	private Message setAppId(Message message) {
		message.setAppId(appId);
		return message;
	}

}
