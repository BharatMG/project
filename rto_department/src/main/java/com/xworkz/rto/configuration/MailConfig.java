package com.xworkz.rto.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class MailConfig {

	public JavaMailSenderImpl mailConfig() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("bharatmg.xworkz@gmail.com");// ur emailAddress
		mailSender.setPassword("kbso sttq keuv dfen"); // ur password
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		return mailSender;
	}
}