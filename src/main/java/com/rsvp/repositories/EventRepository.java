package com.rsvp.repositories;

import com.rsvp.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <h1> Event Repository </h1>
 * The EventRepository is a JPA repository that allows you
 * to perform CRUD operations on the Event entity.
 * It also includes a custom query method to find events occurring after a specified date.
 */
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByDateAfter(LocalDateTime date);

}
