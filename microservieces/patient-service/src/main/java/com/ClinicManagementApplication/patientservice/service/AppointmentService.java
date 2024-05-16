package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.dto.AppointmentDTO;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
    List<AppointmentDTO> getAllAppointments();
    Optional<AppointmentDTO> getAppointmentByAppointmentId(Long appointmentId);

}