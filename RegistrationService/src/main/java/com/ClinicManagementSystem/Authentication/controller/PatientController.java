package com.ClinicManagementSystem.Authentication.controller;

import com.ClinicManagementSystem.Authentication.dto.DoctorDto;
import com.ClinicManagementSystem.Authentication.dto.PatientDto;
import com.ClinicManagementSystem.Authentication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/patient")
@RestController
public class PatientController {


    @Autowired
    private PatientService patientService;


    @PostMapping("/signin")
    public ResponseEntity<PatientDto> patientSignIn(@RequestBody PatientDto patientSignInRequest)
    {
        return ResponseEntity.ok(patientService.PatientSignIn(patientSignInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<PatientDto> patientSignUp(@RequestBody PatientDto patientSignUnRequest)
    {

        return ResponseEntity.ok(patientService.PatientSignUp(patientSignUnRequest));

    }
}
