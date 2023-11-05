package com.rsvp.controllers;

import com.rsvp.entities.Attendee;
import com.rsvp.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1> Attendee Controller </h1>
 * The AttendeeController class defines REST endpoints for managing attendees.
 * It includes methods for retrieving attendees by event ID,
 * creating attendees, and deleting attendees. */
@RestController
@RequestMapping("/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeService attendeeService;

    @GetMapping("/event/{eventId}")
    public List<Attendee> getAttendeesByEventId(@PathVariable Long eventId) {
        return attendeeService.getAttendeesByEventId(eventId);
    }

    @PostMapping
    public Attendee createAttendee(@RequestBody Attendee attendee) {
        return attendeeService.createAttendee(attendee);
    }

    @DeleteMapping("/{attendeeId}")
    public void deleteAttendee(@PathVariable Long attendeeId) {
        attendeeService.deleteAttendee(attendeeId);
    }

}