package com.ClinicManagementSystem.PatientManagementMicroservice.service;

public interface PatientService {

    PatientDto PatientSignIn(PatientDto patientSignInRequest);

    PatientDto PatientSignUp(PatientDto patientSignUnRequest);
}
