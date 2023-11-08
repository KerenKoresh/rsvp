package com.rsvp.controllers;

import com.rsvp.entities.Event;
import com.rsvp.entities.Guest;
import com.rsvp.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Secured("ROLE_USER")
    @PostMapping("/createEvent")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event.getName(), event.getDate());
    }

    @DeleteMapping("/{id}")
    public boolean deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping("/search")
    public List<Event> findEventsByNameContaining(@RequestParam("keyword") String keyword) {
        return eventService.findEventsByNameContaining(keyword);
    }

    @GetMapping("/upcoming")
    public List<Event> findUpcomingEvents() {
        return eventService.findEventsByDateAfter(new Date());
    }

    @PostMapping("/{eventId}/guests")
    public Event addGuestToEvent(
            @PathVariable Long eventId,
            @RequestBody Guest guest
    ) {
        return eventService.addGuestToEvent(eventId, guest.getName(), guest.isAttending());
    }

    @DeleteMapping("/{eventId}/guests/{guestId}")
    public Event removeGuestFromEvent(@PathVariable Long eventId, @PathVariable Long guestId) {
        return eventService.removeGuestFromEvent(eventId, guestId);
    }

    // Additional endpoints for your specific requirements
}
