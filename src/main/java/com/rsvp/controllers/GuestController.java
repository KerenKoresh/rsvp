package com.rsvp.controllers;

import com.rsvp.entities.Guest;
import com.rsvp.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @PostMapping
    public Guest registerGuest(@RequestBody Guest guest) {
        return guestService.registerGuest(guest);
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        return guestService.updateGuest(id, guest.getName(), guest.isAttending());
    }

    @DeleteMapping("/{id}")
    public boolean deleteGuest(@PathVariable Long id) {
        return guestService.deleteGuest(id);
    }

    @GetMapping("/search")
    public List<Guest> findGuestsByNameContaining(@RequestParam("keyword") String keyword) {
        return guestService.findGuestsByNameContaining(keyword);
    }

    @GetMapping("/attending")
    public List<Guest> findAttendingGuests() {
        return guestService.findAttendingGuests();
    }

    // Additional endpoints for your specific requirements
}
