package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.exceptions;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.venuerequestaggregate.VenueRequestStatus;

public class InvalidVenueRequestStateException extends DomainException {
    public InvalidVenueRequestStateException(
            VenueRequestStatus expected,
            VenueRequestStatus actual
    ) {

        super(
                "Expected state "
                    + expected
                    + " but was "
                    + actual
        );

    }

}