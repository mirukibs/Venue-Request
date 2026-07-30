package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.reservationaggregate;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.sharedkernel.TimePeriod;
import lombok.Getter;

public class Reservation {
    private String id;
    @Getter
    private String venueId;
    @Getter
    private String venueRequestId;
    @Getter
    private TimePeriod timePeriod;
    @Getter
    private ReservationStatus status;

    public void cancel() {}

    public void confirm() {}
}
