package com.ClinicManagementSystem.DoctorManagementMicroservice.service;

public interface DoctorService {

    DoctorDto DoctorSignIn(DoctorDto doctorSignInRequest);

    DoctorDto DoctorSignUp(DoctorDto doctorSignUpRequest);
}

