package com.rsvp.services;

import com.rsvp.entities.Attendee;
import com.rsvp.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1> Attendee Service </h1>
 *
 * The AttendeeService class contains methods to interact with the AttendeeRepository.
 * It allows you to retrieve attendees by event ID,
 * create attendees, and delete attendees.
 * */
@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Attendee> getAttendeesByEventId(Long eventId) {
        return attendeeRepository.findByEventId(eventId);
    }

    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Long attendeeId) {
        attendeeRepository.deleteById(attendeeId);
    }


}