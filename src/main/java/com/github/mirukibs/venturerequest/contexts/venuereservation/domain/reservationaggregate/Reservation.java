package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.reservationaggregate;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.shared.TimePeriod;
import lombok.Getter;

import java.util.UUID;

public class Reservation {
    private UUID id;
    @Getter
    private UUID venueId;
    @Getter
    private UUID venueRequestId;
    @Getter
    private TimePeriod timePeriod;
    @Getter
    private ReservationStatus status;

    public void create() {}

    public void cancel() {}

    public void confirm() {}

    public void isConfirmed() {}

    public void isCancelled() {}
}
