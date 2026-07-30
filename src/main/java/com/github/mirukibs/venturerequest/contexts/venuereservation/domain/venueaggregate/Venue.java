package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.venueaggregate;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class Venue {
    private UUID id;
    @Getter
    private String name;
    @Getter
    private VenueSize size;
    @Getter
    private List<String> facilities;

    public void create() {}

    public void rename(String name) {}

    public void addFacility() {}

    public void removeFacility() {}
}
