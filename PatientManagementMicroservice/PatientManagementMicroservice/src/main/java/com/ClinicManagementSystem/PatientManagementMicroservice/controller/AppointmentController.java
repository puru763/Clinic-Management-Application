package com.ClinicManagementSystem.PatientManagementMicroservice.controller;


import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import com.ClinicManagementSystem.PatientManagementMicroservice.service.AppoimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/patient")
@RestController
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    private AppoimentService appoimentService;


    @PostMapping("/book-appointment")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment bookingRequest) {
        Appointment appointment = appoimentService.bookAppointment(bookingRequest);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping("/reschedule-appointment")
    public ResponseEntity<PatientAppointmentDto> rescheduleAppointment(@PathVariable Long appointmentId, @RequestBody PatientAppointmentDto bookingRequest) {
        PatientAppointmentDto booking = appoimentService.rescheduleAppointment(appointmentId, bookingRequest);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/delete-appointments")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId) {
        appoimentService.deleteAppointment(appointmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Appointment has been deleted");
    }

}
