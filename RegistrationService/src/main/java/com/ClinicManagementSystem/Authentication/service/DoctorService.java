package com.ClinicManagementSystem.Authentication.service;

import com.ClinicManagementSystem.Authentication.dto.DoctorDto;

public interface DoctorService {

     DoctorDto DoctorSignIn(DoctorDto doctorSignInRequest) ;

    DoctorDto DoctorSignUp(DoctorDto doctorSignUpRequest);
}
