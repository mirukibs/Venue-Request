package com.github.mirukibs.venturerequest.contexts.venuereservation.domain;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.shared.TimePeriod;

import java.util.UUID;

public class ReservationAvailabilityPolicy {
    private UUID venueId;
    private TimePeriod timePeriod;

    public void checkAvailability() {}

    public void ensureVenueAvailability() {}
}
