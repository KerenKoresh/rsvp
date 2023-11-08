package com.rsvp.services;

import com.rsvp.entities.Event;
import com.rsvp.entities.Guest;
import com.rsvp.repositories.EventRepository;
import com.rsvp.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GuestRepository guestRepository;

    public EventService(EventRepository eventRepository) {
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    public Event createEvent(Long id, String name, Date date, String description) {
        Event event = new Event(id, name, date, description);
        return eventRepository.save(event);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }


    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Long id, String name, Date date) {
        Optional<Event> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setName(name);
            event.setDate(date);
            return eventRepository.save(event);
        }

        return null;
    }

    public boolean deleteEvent(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            eventRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Event> findEventsByNameContaining(String keyword) {
        return eventRepository.findByNameContaining(keyword);
    }

    public List<Event> findEventsByDateAfter(Date date) {
        return eventRepository.findByDateAfter(date);
    }

    public Event addGuestToEvent(Long eventId, String guestName, boolean attending) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);

        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            Guest guest = new Guest(eventId, guestName, attending);
            event.addGuest(guest);
            guestRepository.save(guest);
            return eventRepository.save(event);
        }

        return null;
    }

    public Event removeGuestFromEvent(Long eventId, Long guestId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        Optional<Guest> optionalGuest = guestRepository.findById(guestId);

        if (optionalEvent.isPresent() && optionalGuest.isPresent()) {
            Event event = optionalEvent.get();
            Guest guest = optionalGuest.get();
            event.removeGuest(guest);
            eventRepository.save(event);
            guestRepository.delete(guest);
            return event;
        }

        return null;
    }

    // Add more methods as needed
}