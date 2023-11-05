package com.rsvp;

import com.rsvp.app.RsvpApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RsvpApplication.class) // Specify your application class
class RsvpApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("hhhhh");
	}

}
