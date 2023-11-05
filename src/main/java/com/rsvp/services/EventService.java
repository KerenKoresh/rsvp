package com.rsvp.services;

import com.rsvp.entities.Event;
import com.rsvp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <h1> Event Service </h1>
 *
 * The EventService class contains methods to interact with the EventRepository.
 * It provides functionality to retrieve all events,
 * create events, find upcoming events, and delete events.
 */
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getUpcomingEvents() {
        LocalDateTime now = LocalDateTime.now();
        return eventRepository.findByDateAfter(now);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

}