package com.cognizant.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Email {
	@Id
	private Long id;
	private String from;
	private String[] to;
	private String cc;
	private String bcc;
	private String subject;
	private String text;

}