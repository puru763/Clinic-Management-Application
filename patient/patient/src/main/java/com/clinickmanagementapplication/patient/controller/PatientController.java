package com.clinickmanagementapplication.patient.controller;

import com.clinickmanagementapplication.patient.entity.Patient;
import com.clinickmanagementapplication.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/patient")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient RegisterPatient(@RequestBody Patient patient)
    {
        Patient registerPatient = patientService.RegisterPatient(patient);
        return registerPatient;
    }
}