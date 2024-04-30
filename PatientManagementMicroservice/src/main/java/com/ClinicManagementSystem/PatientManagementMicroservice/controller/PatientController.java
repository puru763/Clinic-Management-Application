package com.ClinicManagementSystem.PatientManagementMicroservice.controller;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.BookingDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/patient")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/signin")
    public ResponseEntity<PatientDto> patientSignIn(@RequestBody PatientDto patientSignInRequest) {
        return ResponseEntity.ok(patientService.PatientSignIn(patientSignInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<PatientDto> patientSignUp(@RequestBody PatientDto patientSignUnRequest) {
        return ResponseEntity.ok(patientService.PatientSignUp(patientSignUnRequest));
    }

    @PostMapping("/book-appointment")
    public ResponseEntity<PatientDto> bookAppointment(@RequestBody BookingDto bookingRequest) {
        PatientDto patient = patientService.BookAppointment(bookingRequest);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/reschedule-appointment")
    public ResponseEntity<PatientDto> rescheduleAppointment(@RequestBody BookingDto bookingRequest) {
        PatientDto patient = patientService.RescheduleAppointment(bookingRequest);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/appointments/{appointmentId}")
    public ResponseEntity<Object> getPatientAppointmentDetails(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(patientService.GetPatientAppointmentDetails(appointmentId));
    }
}