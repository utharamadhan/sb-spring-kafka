package com.rpramadhan.sb.springkafka.consumer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="message")
@Table(name="message")
public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6754010039369072567L;

	private Message() {}
	
	public static Message createInstance(Long id, String content, String sender) {
		Message message = new Message();
		message.setId(id);
		message.setContent(content);
		message.setSender(sender);
		return message;
	}
	
	public static Message createInstance(String title, String author) {
		return Message.createInstance(null, title, author);
	}
	
	@Id
	@JsonProperty("id")
	@SequenceGenerator(name = "message_pk_message_seq", sequenceName = "message_pk_message_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_pk_message_seq")
	@Column(name = "pk_message", unique = true, nullable = false)
	private Long id;
	
	
	@JsonProperty("content")
	@Column(name = "content")
	private String content;
	
	@JsonProperty("sender")
	@Column(name = "sender")
	private String sender;
	
	@JsonProperty("appId")
	@Column(name = "app_id")
	private String appId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
}
