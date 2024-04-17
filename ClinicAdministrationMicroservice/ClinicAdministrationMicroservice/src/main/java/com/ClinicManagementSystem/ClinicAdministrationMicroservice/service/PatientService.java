package com.ClinicManagementSystem.Authentication.service;

import com.ClinicManagementSystem.Authentication.dto.PatientDto;

public interface PatientService {



    PatientDto PatientSignIn(PatientDto patientSignInRequest);

    PatientDto PatientSignUp(PatientDto patientSignUnRequest);
}
