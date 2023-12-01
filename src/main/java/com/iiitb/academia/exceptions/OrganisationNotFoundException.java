package com.iiitb.academia.exceptions;

public class OrganisationNotFoundException extends RuntimeException {
    public OrganisationNotFoundException(String message) {
        super(message);
    }

    public OrganisationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrganisationNotFoundException(Throwable cause) {
        super(cause);
    }
}
