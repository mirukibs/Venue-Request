package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.reservationaggregate;

public interface ReservationRepository {
    public void save(Reservation reservation);
    public void findById(String id);
    public void findReservationsForVenue(String venueId);
}
