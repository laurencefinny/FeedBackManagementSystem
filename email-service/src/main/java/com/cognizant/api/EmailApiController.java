package com.cognizant.api;

import java.util.Optional;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.entity.Email;
import com.cognizant.model.VolunteerRegistered;
import com.cognizant.model.VolunteerUnRegistered;
import com.cognizant.repository.VolunteerRegisteredRepository;
import com.cognizant.repository.VolunteerUnRegisteredRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-25T09:06:38.313+05:30[Asia/Calcutta]")
@Controller
public class EmailApiController implements EmailApi {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public EmailApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Autowired
	private VolunteerRegisteredRepository volunteerRegisteredRepository;
	@Autowired
	private VolunteerUnRegisteredRepository volunteerUnRegisteredRepository;

	@Override
	public Mono<Boolean> sendEmail() {

		Email email = new Email();
		email.setFrom("tnotcc@gmail.com");
		email.setSubject("Tell us how much you like it");
		email.setText("Hi Participants, we kindly request you to provide valuable feedback by clicking the below link");
		Flux<VolunteerRegistered> reg = volunteerRegisteredRepository.findAll();
		Flux<VolunteerUnRegistered> un_reg = volunteerUnRegisteredRepository.findAll();
		String[] reg_email = reg.filter(r -> r.getEmployeeId() != null).map(VolunteerRegistered::getEmployeeId)
				.collectList().block().stream().map(emailAdd -> emailAdd + "@gmail.com").toArray(String[]::new);

		String[] un_reg_email = un_reg.filter(r -> r.getEmployeeId() != null).map(VolunteerUnRegistered::getEmployeeId)
				.collectList().block().stream().map(emailAdd -> emailAdd + "@gmail.com").toArray(String[]::new);

		String[] arr = { "rk001don@gmail.com" };
		email.setCc(reg.blockFirst().getEventName());
		System.err.println(reg.map(r -> r.getEventId()).collectList());
		email.setTo(arr);

		try {
			send(email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Mono<Boolean> sendEventEmail(
			@ApiParam(value = "email", required = true) @PathVariable("eventId") Integer eventId) {

		Email email = new Email();
		email.setFrom("tnotcc@gmail.com");
		email.setSubject("Tell us how much you like it");
		email.setText("Hi Participants, we kindly request you to provide valuable feedback by clicking the below link");
		Flux<VolunteerRegistered> reg = volunteerRegisteredRepository.findByEventId(eventId);
		Flux<VolunteerUnRegistered> un_reg = volunteerUnRegisteredRepository.findByEventId(eventId);
		Flux<Long> arr1 = reg.filter(r -> r.getEmployeeId() != null).map(VolunteerRegistered::getEmployeeId);
		Flux<Long> arr2 = un_reg.filter(r -> r.getEmployeeId() != null).map(VolunteerUnRegistered::getEmployeeId);
		String[] emailArr = arr1.mergeWith(arr2).collectList().block().stream().map(emailAdd -> emailAdd + "@gmail.com")
				.toArray(String[]::new);

		email.setTo(emailArr);
		try {
			send(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.mailtrap.io");
//	    mailSender.setPort(2525);  
//	    mailSender.setUsername("fee58ce99ef0a4");
//	    mailSender.setPassword("437798652c0a9c");
	    
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);  
	    mailSender.setUsername("tnotcc@gmail.com");
	    mailSender.setPassword("15BEE@2019mkce"); 
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	      
	    return mailSender;
	}

	@Autowired
	JavaMailSender JavaMailSender;
	public Boolean send(Email email) throws MailException, InterruptedException, MessagingException {
		

		System.err.println(email);
		
		MimeMessage mimeMessage = getJavaMailSender().createMimeMessage();
		
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "utf-8");
			message.setFrom(email.getFrom());
			message.setSubject(email.getSubject());
			message.setText("<div style=\"margin:25px;width:800px\">\n" + 
					"	<div style=\"border: blue solid 2px; text-align:center;\">\n" + 
					"		<div style=\"background-color: blue; color: white; padding: 1px ;\">\n" + 
					"			<h3>!!!  Help us to SERVE BETTER !!! </h3>\n" + 
					"		</div>\n" + 
					"		<div style=\"width:800px; height:140px; padding: 3x\">\n" + 
					"			<h3>"+email.getCc()+"</h3>\n" + 
					"			<p >"+email.getText()+"</p>\n" + 
					"			<a href=\"#\" style=\" background-color:#32CD42; color: white;padding: 8px 18px;text-align: center;text-decoration: none;display: inline-block;font-size: 14px;\"><< Click>></a>\n" + 
					"		</div>\n" + 
					"		<div style=\"background-color: blue; color: white; padding: 4px; font-size: small\">© Copyright 2020</div>\n" + 
					"	</div>\n" + 
					"</div>\n" + 
					"", true);
			message.setTo(email.getTo());
			System.err.println(mimeMessage);
			getJavaMailSender().send(mimeMessage);
		

		return Boolean.TRUE;
	}
}
