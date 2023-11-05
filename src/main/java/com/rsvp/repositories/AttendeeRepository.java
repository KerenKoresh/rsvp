package com.rsvp.repositories;

import com.rsvp.entities.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h1> Attendee Repository </h1>
 *
 * The AttendeeRepository is a JPA repository for the Attendee entity.
 * It includes a custom query method to find attendees by event ID.
 */
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

    List<Attendee> findByEventId(Long eventId);

}
