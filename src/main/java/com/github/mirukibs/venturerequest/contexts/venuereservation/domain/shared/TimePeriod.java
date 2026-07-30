package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.shared;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimePeriod {
    @Getter
    private LocalDate date;
    @Getter
    private LocalTime startTime;
    @Getter
    private LocalTime endTime;

    public void create() {}

    public void overlaps(TimePeriod period) {}

    public void duration() {}

    public void validate() {}
}
