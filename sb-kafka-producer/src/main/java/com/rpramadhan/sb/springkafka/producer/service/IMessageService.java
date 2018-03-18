package com.rpramadhan.sb.springkafka.producer.service;

import com.rpramadhan.sb.springkafka.producer.model.Message;

public interface IMessageService {
	
	public Message sendMessage(Message book);

}
