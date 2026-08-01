package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.venuerequestaggregate;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.exceptions.InvalidVenueRequestStateException;
import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.shared.TimePeriod;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

public class VenueRequest {
    @Getter
    private final UUID id;
    @Getter
    private String title;
    @Getter
    private String description;
    @Getter
    private final UUID requesterId;
    @Getter
    private UUID venueId;
    @Getter
    private TimePeriod timePeriod;
    @Getter
    private VenueRequestStatus status;

    private VenueRequest(
            UUID id,
            String title,
            String description,
            UUID requesterId,
            UUID venueId,
            TimePeriod timePeriod,
            VenueRequestStatus status
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requesterId = requesterId;
        this.venueId = venueId;
        this.timePeriod = timePeriod;
        this.status = status;
    }

    public static VenueRequest create(
            String title,
            String description,
            UUID requesterId,
            UUID venueId,
            TimePeriod timePeriod
    ) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(requesterId);
        Objects.requireNonNull(venueId);
        Objects.requireNonNull(timePeriod);

        return new VenueRequest(
                UUID.randomUUID(),
                title,
                description,
                requesterId,
                venueId,
                timePeriod,
                VenueRequestStatus.DRAFT
        );
    }

    private void requireDraft() {
        if (!isDraft()) {
            throw new InvalidVenueRequestStateException(
                    VenueRequestStatus.DRAFT,
                    status
            );
        }
    }

    private void requirePendingReview() {
        if (!isPendingReview()) {
            throw new InvalidVenueRequestStateException(
                    VenueRequestStatus.PENDING_REVIEW,
                    status
            );
        }
    }

    public void submit() {
        requireDraft();
        this.status = VenueRequestStatus.PENDING_REVIEW;
    }

    public void approve() {
        requirePendingReview();
        this.status = VenueRequestStatus.APPROVED;
    }

    public void reject() {
        requirePendingReview();
        this.status = VenueRequestStatus.REJECTED;
    }

    public boolean isDraft() {
        return this.status == VenueRequestStatus.DRAFT;
    }

    public boolean isPendingReview() {
        return this.status == VenueRequestStatus.PENDING_REVIEW;
    }

    public boolean isApproved() {
        return this.status == VenueRequestStatus.APPROVED;
    }

    public boolean isRejected() {
        return this.status == VenueRequestStatus.REJECTED;
    }

    public void changeTitle(String title) {
        requireDraft();
        this.title = title;
    }

    public void changeVenue(UUID venueId) {
        requireDraft();
        this.venueId = venueId;
    }

    public void changeDescription(String description) {
        requireDraft();
        this.description = description;
    }

    public void changeTimePeriod(TimePeriod timePeriod) {
        requireDraft();
        this.timePeriod = timePeriod;
    }

    public void editVenueRequest(
            String title,
            String description,
            UUID venueId,
            TimePeriod timePeriod
    ) {
        changeTitle(title);
        changeDescription(description);
        changeVenue(venueId);
        changeTimePeriod(timePeriod);
    }

    @Override
    public String toString() {
        return "VenueRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", requesterId=" + requesterId +
                ", venueId=" + venueId +
                ", timePeriod=" + timePeriod +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof VenueRequest other)) {
            return false;
        }

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
