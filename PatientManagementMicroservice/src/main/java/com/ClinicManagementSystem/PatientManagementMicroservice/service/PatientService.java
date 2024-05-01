package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;

public interface PatientService {


    PatientAppointmentDto bookAppointment(PatientAppointmentDto bookingRequest);

    PatientAppointmentDto rescheduleAppointment(Long appointmentId, PatientAppointmentDto bookingRequest);


    PatientAppointmentDto getPatientAppointmentDetails(Long appointmentId);

    void deleteAppointment(Long appointmentId);
}
