package com.mursalin.MailSenderDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MailSenderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSenderDemoApplication.class, args);
	}

}
