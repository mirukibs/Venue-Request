package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.venueaggregate;

import lombok.Getter;

import java.util.List;

public class Venue {
    private String id;
    @Getter
    private String name;
    @Getter
    private VenueSize size;
    @Getter
    private List<String> facilities;

    public void rename() {}

    public void updateFacilities() {}
}
