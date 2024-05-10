package com.ClinicManagementApplication.patientservice.controller;

import com.ClinicManagementApplication.patientservice.dto.AppointmentDTO;
import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.service.AppointmentService;
import com.ClinicManagementApplication.patientservice.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/register-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
        try {
            Patient registerPatient = patientService.registerPatient(patient);
            if (registerPatient != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(registerPatient);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Patient  With This Mobile Number Is  Already Exist Please Try  With Differnt Mobile Number");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Error Occured During Patient Register");
        }
    }

    @PostMapping("/book-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> bookAppointment(@RequestBody Appointment appointment) {
        try {
            Appointment bookedAppointment = appointmentService.bookAppointment(appointment);
            if (bookedAppointment != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(bookedAppointment);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to book the appointment. Please check your data.");
            }
        } catch (Exception e) {
            LOGGER.error("Error booking appointment: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while booking the appointment.");
        }
    }

    @GetMapping("/{patientId}/appointments")
    public ResponseEntity<?> getPatientAppointments(@PathVariable Long patientId) {
        try {
            List<Appointment> appointments = patientService.getAppointmentsForPatient(patientId);
            if (appointments.isEmpty()) {
                return ResponseEntity.status(404).body("No appointments found for this patient");
            } else {
                return ResponseEntity.ok(appointments);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while fetching appointments");
        }
    }



    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        try {
            List<PatientDTO> patients = patientService.getAllPatients();
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        try {
            List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/appointments/{appointmentId}")
    public ResponseEntity<Optional<AppointmentDTO>> getAppointmentByAppointmentId(@PathVariable Long appointmentId) {
        try {
            Optional<AppointmentDTO> appointment = appointmentService.getAppointmentByAppointmentId(appointmentId);
            if (appointment != null) {
                return ResponseEntity.ok(appointment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<PatientDTO> getPatientByPatientId(@PathVariable Long patientId) {
        try {
            PatientDTO patient = patientService.getPatientByPatientId(patientId);
            if (patient != null) {
                return ResponseEntity.ok(patient);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    }








