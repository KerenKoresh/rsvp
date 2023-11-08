package com.rsvp.repositories;

import com.rsvp.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByDateAfter(Date date);

    List<Event> findByNameContains(String keyword);

    List<Event> findByNameContaining(String keyword);

    // Add more custom queries or methods here as needed
}
