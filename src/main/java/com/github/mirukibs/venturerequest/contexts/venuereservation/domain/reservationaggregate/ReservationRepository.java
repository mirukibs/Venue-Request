package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.reservationaggregate;

import java.util.UUID;

public interface ReservationRepository {
    public void save(Reservation reservation);
    public void findById(UUID id);
    public void findReservationsForVenue(String venueId);
}
