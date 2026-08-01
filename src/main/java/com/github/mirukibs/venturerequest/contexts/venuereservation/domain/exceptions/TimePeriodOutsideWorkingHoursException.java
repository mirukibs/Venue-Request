package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.exceptions;

public class TimePeriodOutsideWorkingHoursException extends DomainException{
    public TimePeriodOutsideWorkingHoursException(String message) {
        super(message);
    }
}
