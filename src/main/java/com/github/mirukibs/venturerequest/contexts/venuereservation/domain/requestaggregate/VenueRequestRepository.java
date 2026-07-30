package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.requestaggregate;

public interface VenueRequestRepository {
    public void save(VenueRequest venueRequest);
    public void findById(String id);
}
