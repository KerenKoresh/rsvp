package com.rsvp.repositories;

import com.rsvp.entities.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findByAttendingTrue(); // Find guests who are attending

    List<Guest> findByAttendingFalse(); // Find guests who are not attending

    List<Guest> findByName(String name); // Find a guest by name

    List<Guest> findByAttendingAndName(boolean attending, String name); // Find guests by attending status and name

    // Add more custom queries or methods here as needed
}
