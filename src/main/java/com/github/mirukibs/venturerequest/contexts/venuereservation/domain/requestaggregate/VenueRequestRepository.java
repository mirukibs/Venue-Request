package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.requestaggregate;

import java.util.UUID;

public interface VenueRequestRepository {
    public void save(VenueRequest venueRequest);
    public void findById(UUID id);
}
