package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.venueaggregate;

import java.util.UUID;

public interface VenueRepository {
    public void save(Venue venue);
    public void findById(UUID id);
    public void findAll();
}
