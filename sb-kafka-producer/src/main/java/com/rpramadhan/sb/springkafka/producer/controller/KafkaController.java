package com.rpramadhan.sb.springkafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rpramadhan.sb.springkafka.producer.model.Message;
import com.rpramadhan.sb.springkafka.producer.model.Response;
import com.rpramadhan.sb.springkafka.producer.service.IMessageService;

@RestController
public class KafkaController {
	
	@Autowired
	private IMessageService service;
	
	@RequestMapping(value = "/send", method=RequestMethod.POST)
	public ResponseEntity<Response> post(@RequestBody Message book) {
		return ResponseEntity.badRequest().body(Response.createInstance(service.sendMessage(book)));
	}
	
}
