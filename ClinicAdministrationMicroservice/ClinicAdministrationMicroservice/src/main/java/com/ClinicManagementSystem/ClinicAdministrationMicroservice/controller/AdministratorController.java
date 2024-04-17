package com.ClinicManagementSystem.ClinicAdministrationMicroservice;


import com.ClinicManagementSystem.Authentication.dto.AdministratorDto;
import com.ClinicManagementSystem.Authentication.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/administrator")
@RestController
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/login")
    public ResponseEntity<AdministratorDto> administratorSignIn(@RequestBody AdministratorDto administratorSignInRequest)
    {
        return ResponseEntity.ok(administratorService.administratorsignup(administratorSignInRequest));

    }

}
