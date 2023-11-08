package com.rsvp;

import com.rsvp.app.EventRsvpApplication;
import com.rsvp.entities.Event;
import com.rsvp.repositories.EventRepository;
import com.rsvp.services.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = EventRsvpApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = "com.rsvp")
public class EventServiceTest {

	@InjectMocks
	private EventService eventService;

	@Mock
	private EventRepository eventRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllEvents() {
		// Arrange
		List<Event> mockEvents = new ArrayList<>();
		mockEvents.add(new Event(1L, "Event 1", new Date(), ""));
		mockEvents.add(new Event(2L, "Event 2", new Date(), ""));
		when(eventRepository.findAll()).thenReturn(mockEvents);

		// Act
		List<Event> events = eventService.getAllEvents();

		// Assert
		assertEquals(2, events.size());
	}

	@Test
	public void testGetEventById() {
		// Arrange
		Long eventId = 1L;
		Event mockEvent = new Event(1L, "Event 1", new Date(), "");
		when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));

		// Act
		Optional<Event> event = eventService.getEventById(eventId);

		// Assert
		assertEquals(mockEvent, event.orElse(null));
	}

	@Test
	public void testCreateEvent() {
		// Arrange
		Event eventToCreate = new Event(1L, "Event 1", new Date(), "");
		when(eventRepository.save(eventToCreate)).thenReturn(eventToCreate);

		// Act
		Event createdEvent = eventService.createEvent(eventToCreate);

		// Assert
		assertEquals(eventToCreate, createdEvent);
	}

	@Test
	public void testDeleteEvent() {
		// Arrange
		Long eventId = 1L;
		Event eventToCreate = new Event(eventId, "Event 1", new Date(), "");
		when(eventRepository.save(eventToCreate)).thenReturn(eventToCreate);

		// Act
		Event createdEvent = eventService.createEvent(eventToCreate);
		eventService.deleteEvent(eventId);

		// Assert
		verify(eventRepository, times(1)).deleteById(eventId);
	}
}
