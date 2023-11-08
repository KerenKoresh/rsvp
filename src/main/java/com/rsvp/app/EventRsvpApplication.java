package com.rsvp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rsvp.repositories")
@EntityScan(basePackages = "com.rsvp.entities")
public class EventRsvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventRsvpApplication.class, args);
	}

}
