package com.rpramadhan.sb.springkafka.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpramadhan.sb.springkafka.consumer.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
