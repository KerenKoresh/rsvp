package com.rsvp;

import com.rsvp.app.EventRsvpApplication;
import com.rsvp.entities.Guest;
import com.rsvp.repositories.GuestRepository;
import com.rsvp.services.GuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = EventRsvpApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = "com.rsvp")
public class GuestServiceTest {

    @InjectMocks
    private GuestService guestService;

    @Mock
    private GuestRepository guestRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllGuests() {
        // Arrange
        List<Guest> mockGuests = new ArrayList<>();
        mockGuests.add(new Guest(1L, "Guest 1", true));
        mockGuests.add(new Guest(2L, "Guest 2", false));
        when(guestRepository.findAll()).thenReturn(mockGuests);

        // Act
        List<Guest> guests = guestService.getAllGuests();

        // Assert
        assertEquals(2, guests.size());
    }

    @Test
    public void testGetGuestById() {
        // Arrange
        Long guestId = 1L;
        Guest mockGuest = new Guest(guestId, "Guest 1", true);
        when(guestRepository.findById(guestId)).thenReturn(Optional.of(mockGuest));

        // Act
        Optional<Guest> guest = guestService.getGuestById(guestId);

        // Assert
        assertEquals(mockGuest, guest.orElse(null));
    }

    @Test
    public void testCreateGuest() {
        // Arrange
        Guest guestToCreate = new Guest(3L, "Guest 3", true);
        when(guestRepository.save(guestToCreate)).thenReturn(guestToCreate);

        // Act
        Guest createdGuest = guestService.createGuest(guestToCreate);

        // Assert
        assertEquals(guestToCreate, createdGuest);
    }

    @Test
    public void testDeleteGuest() {
        // Arrange
        Long guestId = 1L;

        // Mock the behavior of guestRepository.findById
        Guest guestToDelete = new Guest(guestId, "Guest to delete", true);
        when(guestRepository.findById(guestId)).thenReturn(Optional.of(guestToDelete));

        // Act
        guestService.deleteGuest(guestId);

        // Assert
        // Assert
        verify(guestRepository, times(1)).findById(guestId);
        verify(guestRepository, times(1)).deleteById(guestId); // Use deleteById instead of delete
    }

}