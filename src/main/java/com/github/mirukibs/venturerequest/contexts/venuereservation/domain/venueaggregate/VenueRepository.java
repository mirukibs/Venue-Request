package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.venueaggregate;

public interface VenueRepository {
    public void save(Venue venue);
    public void findById(String id);
}
