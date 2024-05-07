package com.clinickmanagementapplication.patient.exception;

public class PatientAlreadyRegisteredException extends RuntimeException {
    public PatientAlreadyRegisteredException(String message) {
        super(message);
    }
}