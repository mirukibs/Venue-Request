package com.github.mirukibs.venturerequest.contexts.venuereservation.domain;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.shared.TimePeriod;

import java.util.UUID;

public class ReservationAvailabilityPolicy {
    public void checkAvailability(UUID venueId, TimePeriod timePeriod) {}

    public void ensureVenueAvailability(UUID venueId, TimePeriod timePeriod) {}
}
