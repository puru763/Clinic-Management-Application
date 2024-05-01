package com.ClinicManagementSystem.PatientManagementMicroservice.controller;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import com.ClinicManagementSystem.PatientManagementMicroservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/patient")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

     @PostMapping("/register-patient")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patientRegistrationRequest) {
         Patient patientRegistration = patientService.registerPatient(patientRegistrationRequest);
        return ResponseEntity.ok(patientRegistration);
    }

    @PostMapping("/book-appointment")
    public ResponseEntity<PatientAppointmentDto> bookAppointment(@RequestBody PatientAppointmentDto bookingRequest) {
        PatientAppointmentDto booking = patientService.bookAppointment(bookingRequest);
        return ResponseEntity.ok(booking);
    }

    @PostMapping("/reschedule-appointment")
    public ResponseEntity<PatientAppointmentDto> rescheduleAppointment(@PathVariable Long appointmentId, @RequestBody PatientAppointmentDto bookingRequest) {
        PatientAppointmentDto booking = patientService.rescheduleAppointment(appointmentId, bookingRequest);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/my-appointments")
    public ResponseEntity<PatientAppointmentDto> getPatientAppointmentDetails(@PathVariable Long appointmentId) {
        PatientAppointmentDto patientAppointment = patientService.getPatientAppointmentDetails(appointmentId);
        return ResponseEntity.ok(patientAppointment);
    }

    @DeleteMapping("/delete-appointments")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId) {
        patientService.deleteAppointment(appointmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Appointment has been deleted");
    }
}
