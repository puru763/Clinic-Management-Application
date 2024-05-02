package com.ClinicManagementSystem.PatientManagementMicroservice.controller;


import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import com.ClinicManagementSystem.PatientManagementMicroservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/patient")
@RestController
@RequiredArgsConstructor
public class PatientController {

    @Autowired
    private PatientService patientService;



    @PostMapping("/register-patient")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patientRegistrationRequest) {
        Patient patientRegistration = patientService.registerPatient(patientRegistrationRequest);
        return ResponseEntity.ok(patientRegistration);
    }


    @GetMapping("/my-appointments")
    public ResponseEntity<PatientAppointmentDto> getPatientAppointmentDetails(@PathVariable Long appointmentId) {
        PatientAppointmentDto patientAppointment = patientService.getPatientAppointmentDetails(appointmentId);
        return ResponseEntity.ok(patientAppointment);
    }



}
