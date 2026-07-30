package com.github.mirukibs.venturerequest.contexts.venuereservation.requestaggregate;

import lombok.Getter;

public class VenueRequest {
    @Getter
    private String id;
    @Getter
    private String title;
    @Getter
    private String description;
    @Getter
    private String requesterId;
    @Getter
    private String venueId;
    @Getter
    private TimePeriod timePeriod;
    @Getter
    private RequestStatus status;

    public void submit() {}

    public void approve() {}

    public void reject() {}

    public void isDraft() {}

    public void isPendingReview() {}

    public void isApproved() {}

    public void isRejected() {}
}
