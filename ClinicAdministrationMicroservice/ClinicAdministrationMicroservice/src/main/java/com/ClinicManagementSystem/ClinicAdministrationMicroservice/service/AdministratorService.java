package com.ClinicManagementSystem.ClinicAdministrationMicroservice;

import com.ClinicManagementSystem.Authentication.dto.AdministratorDto;

public interface AdministratorService {
    AdministratorDto administratorsignup(AdministratorDto adminSignInRequest);
}
