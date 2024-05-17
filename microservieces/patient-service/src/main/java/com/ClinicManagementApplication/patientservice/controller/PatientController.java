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
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @PostMapping("/register-patient")
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
        try {
            Patient registeredPatient = patientService.registerPatient(patient);
            if (registeredPatient != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(registeredPatient);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient with this mobile number already exists");
            }
        } catch (RuntimeException e) {
            LOGGER.error("Error occurred during patient registration: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during patient registration");
        } catch (Exception e) {
            LOGGER.error("Unexpected error occurred during patient registration: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred during patient registration");
        }
    }

    @GetMapping("/get-all-patients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        try {
            List<PatientDTO> patients = patientService.getAllPatients();
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching all patients: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get-patient-by-id/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable Long patientId) {
        try {
            PatientDTO getPatient = patientService.getPatientByPatientId(patientId);
            if (getPatient != null) {
                return ResponseEntity.ok(getPatient);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found for ID: " + patientId);
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching patient by ID: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching patient");
        }
    }

    @PostMapping("/{patientId}/book-appointment")
    public ResponseEntity<?> bookAppointment(@PathVariable Long patientId, @RequestBody Appointment appointment) {
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
