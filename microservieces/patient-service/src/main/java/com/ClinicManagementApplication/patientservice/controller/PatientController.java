// Renamed package name to lowercase
package com.ClinicManagementApplication.patientservice.controller;

import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    // Constructor injection for PatientService
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/register-patient")
    public ResponseEntity<?> registerPatient(@Valid @RequestBody Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid patient data");
        }
        try {
            Patient registeredPatient = patientService.registerPatient(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredPatient);
        } catch (Exception e) {
            LOGGER.error("Error occurred during patient registration: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during patient registration");
        }
    }

    @PostMapping("/{patientId}/book-appointment")
    public ResponseEntity<?> bookAppointment(@PathVariable Long patientId, @Valid @RequestBody Appointment appointment, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid appointment data");
        }
        try {
            Appointment updatedPatient = patientService.bookAppointment(patientId, appointment);
            return ResponseEntity.ok(updatedPatient);
        } catch (RuntimeException e) {
            LOGGER.error("Error occurred while adding appointment: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        } catch (Exception e) {
            LOGGER.error("Unexpected error occurred while adding appointment: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred while adding appointment");
        }
    }
}
