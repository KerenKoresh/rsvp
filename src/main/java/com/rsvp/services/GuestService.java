package com.rsvp.services;

import com.rsvp.entities.Guest;
import com.rsvp.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return (List<Guest>) guestRepository.findAll();
    }

    public Guest registerGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest updateGuest(Long id, String name, boolean attending) {
        Optional<Guest> optionalGuest = guestRepository.findById(id);

        if (optionalGuest.isPresent()) {
            Guest guest = optionalGuest.get();
            guest.setName(name);
            guest.setAttending(attending);
            return guestRepository.save(guest);
        }

        return null;
    }

    public boolean deleteGuest(Long id) {
        Optional<Guest> optionalGuest = guestRepository.findById(id);

        if (optionalGuest.isPresent()) {
            guestRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Guest> findGuestsByNameContaining(String keyword) {
        List<Guest> guests = new ArrayList<>();
        List<Guest> all = (List<Guest>) guestRepository.findAll();

        for (var guest: all) {
            if(guest.getName().contains(keyword))
                guests.add(guest);
        }
        return guests;

    }

    public List<Guest> findAttendingGuests() {
        return guestRepository.findByAttendingTrue();
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }
}
