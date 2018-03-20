package com.rpramadhan.sb.springkafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.rpramadhan.sb.springkafka.consumer.SBConsumerMain;

/**
 * @author rpramadhan
 * Enter point for Unit Test H2 Application
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.rpramadhan.sb.springkafka.producer"}, excludeFilters={
		  @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=SBConsumerMain.class)})
@EntityScan({"com.rpramadhan.sb.springkafka.producer.model"})
public class SBProducerTest {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SBProducerTest.class, args);
	}

}
