package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;

public interface PatientService {


    PatientAppointmentDto bookAppointment(PatientAppointmentDto bookingRequest);

    PatientAppointmentDto rescheduleAppointment(Long appointmentId, PatientAppointmentDto bookingRequest);


    PatientAppointmentDto getPatientAppointmentDetails(Long appointmentId);

    void deleteAppointment(Long appointmentId);

    Patient registerPatient(Patient patientRegistrationRequest);
}
