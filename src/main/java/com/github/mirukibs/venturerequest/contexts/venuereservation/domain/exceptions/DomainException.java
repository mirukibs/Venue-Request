package com.github.mirukibs.venturerequest.contexts.venuereservation.domain.exceptions;

public abstract class DomainException extends RuntimeException {

    protected DomainException(String message) {
        super(message);
    }

}