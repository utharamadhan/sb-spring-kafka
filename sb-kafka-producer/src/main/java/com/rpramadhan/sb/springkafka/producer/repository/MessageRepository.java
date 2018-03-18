package com.rpramadhan.sb.springkafka.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpramadhan.sb.springkafka.producer.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
