package com.rsvp.entities;

import jakarta.persistence.*;

/**
 * <h1>Attendee</h1>
 *
 * The Attendee class is an entity representing an attendee.
 * It includes constructors for creating instances and
 * getters and setters for accessing and modifying the properties.
 */
@Entity
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Event event;

    // Constructors
    public Attendee() {
        // Default no-argument constructor
    }

    public Attendee(String name, Event event) {
        this.name = name;
        this.event = event;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}