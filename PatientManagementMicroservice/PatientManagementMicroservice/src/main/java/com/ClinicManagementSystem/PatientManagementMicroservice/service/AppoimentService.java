package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;

public interface AppoimentService {
    Appointment bookAppointment(Appointment bookingRequest);
    public PatientAppointmentDto rescheduleAppointment(Long appointmentId, Appointment bookingRequest);
    void deleteAppointment(Long appointmentId);
}
