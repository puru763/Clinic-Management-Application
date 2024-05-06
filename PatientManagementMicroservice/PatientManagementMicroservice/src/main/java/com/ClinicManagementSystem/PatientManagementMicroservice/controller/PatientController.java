package com.ClinicManagementSystem.PatientManagementMicroservice.controller;


import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientDTO;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import com.ClinicManagementSystem.PatientManagementMicroservice.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/user")
@RestController
public class PatientController {

private  final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }



    @PostMapping("/register-user")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDTO RegisterPatient(@RequestBody Patient patient){
        Patient createdPatient = patientService.RegisterPatient(patient);
        return new Patient(createdPatient);
    }

    @PostMapping("/book-appoiment")
    @ResponseStatus(HttpStatus.CREATED)
    public AppoimentDto RegisterPatient(@RequestBody Appointment Appointment){
        Appointment createdAppointment = patientService.RegisterPatient(patient);
        return new Patient(createdPatient);
    }



}