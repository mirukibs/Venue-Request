package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.requestaggregate;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.shared.TimePeriod;
import lombok.Getter;

import java.util.UUID;

public class VenueRequest {
    @Getter
    private UUID id;
    @Getter
    private String title;
    @Getter
    private String description;
    @Getter
    private UUID requesterId;
    @Getter
    private UUID venueId;
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
