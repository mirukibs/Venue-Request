package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.shared;

import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.exceptions.InvalidTimePeriodException;
import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.exceptions.TimePeriodOutsideWorkingHoursException;
import com.github.mirukibs.venturerequest.contexts.venuereservation.domain.exceptions.TimePeriodTooShortException;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@EqualsAndHashCode
public final class TimePeriod {
    @Getter
    private final LocalDate date;
    @Getter
    private final LocalTime startTime;
    @Getter
    private final LocalTime endTime;
    private static final LocalTime OPENING_TIME = LocalTime.of(7, 0);
    private static final LocalTime CLOSING_TIME = LocalTime.of(17, 0);

    private TimePeriod(
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime
    ) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static TimePeriod create(
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime
    ) {
        TimePeriod period = new TimePeriod(
                date,
                startTime,
                endTime
        );

        period.validate();

        return period;
    }

    private void validate() {
        validateRequiredFields();
        validateChronology();
        validateMinimumDuration();
        validateWorkingHours();
    }

    private void validateRequiredFields() {
        if (date == null) {
            throw new InvalidTimePeriodException("Date is required.");
        }

        if (startTime == null) {
            throw new InvalidTimePeriodException("Start time is required.");
        }

        if (endTime == null) {
            throw new InvalidTimePeriodException("End time is required.");
        }
    }

    private void validateChronology() {
        if (!endTime.isAfter(startTime)) {
            throw new InvalidTimePeriodException(
                    "End time must occur after the start time."
            );
        }
    }

    private void validateMinimumDuration() {
        if (duration().toMinutes() < 60) {
            throw new TimePeriodTooShortException(
                    "Minimum duration is 1 hr (60 mins)."
            );
        }
    }

    private void validateWorkingHours() {
        if (startTime.isBefore(OPENING_TIME)) {
            throw new TimePeriodOutsideWorkingHoursException(
                    "A reservation must start at or after 07:00."
            );
        }

        if (endTime.isAfter(CLOSING_TIME)) {
            throw new TimePeriodOutsideWorkingHoursException(
                    "A reservation must end at or before 17:00."
            );
        }
    }

    public boolean overlaps(TimePeriod otherTimePeriod) {
        Objects.requireNonNull(otherTimePeriod);

        if(!date.equals(otherTimePeriod.date)) {
            return false;
        }

        return
                startTime.isBefore(otherTimePeriod.endTime) && otherTimePeriod.startTime.isBefore(endTime);
    }

    public Duration duration() {
        return Duration.between(startTime, endTime);
    }
}
