package com.rsvp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rsvp")

public class RsvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsvpApplication.class, args);
	}

}
