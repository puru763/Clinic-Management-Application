
package com.ClinicManagementSystem.Authentication.service.impl;

import com.ClinicManagementSystem.Authentication.dto.AdministratorDto;
import com.ClinicManagementSystem.Authentication.service.AdministratorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Value("${administartion.Number}")
    private String fixedNumber;

    @Value("${administartion.Password}")
    private String fixedPassword;

    @Override
    public AdministratorDto administratorsignup(AdministratorDto adminSignInRequest) {
        if (adminSignInRequest.getNumber().equals(fixedNumber) && adminSignInRequest.getPassword().equals(fixedPassword)) {
            return new AdministratorDto(adminSignInRequest.getNumber(), adminSignInRequest.getPassword());
        } else {
            return null;
        }
    }


}
