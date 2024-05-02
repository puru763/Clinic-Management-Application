package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;

public interface PatientService {
    Patient registerPatient(Patient patientRegistrationRequest);
    PatientAppointmentDto getPatientAppointmentDetails(Long appointmentId);
}
