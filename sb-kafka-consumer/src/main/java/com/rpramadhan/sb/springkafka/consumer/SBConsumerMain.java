package com.rpramadhan.sb.springkafka.consumer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import liquibase.integration.spring.SpringLiquibase;

/**
 * @author rpramadhan
 * Enter point for Spring Boot Kafka Producer
 */
@SpringBootApplication
@EntityScan({"com.rpramadhan.sb.springkafka.consumer.model"})
@EnableJpaRepositories({"com.rpramadhan.sb.springkafka.consumer.repository"})
public class SBConsumerMain {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SBConsumerMain.class, args);
	}

	@Bean
	public SpringLiquibase liquibase() {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:liquibase/liquibase.xml");
		liquibase.setDataSource(dataSource);
		return liquibase;
	}

}
