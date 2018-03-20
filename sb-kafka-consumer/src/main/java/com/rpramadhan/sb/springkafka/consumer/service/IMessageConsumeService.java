package com.rpramadhan.sb.springkafka.consumer.service;

import com.rpramadhan.sb.springkafka.consumer.model.Message;

public interface IMessageConsumeService {
	
	public Message saveMessage(Message message);

}
