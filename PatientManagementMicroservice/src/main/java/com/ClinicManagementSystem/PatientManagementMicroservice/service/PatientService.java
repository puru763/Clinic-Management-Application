package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientDto;

public interface PatientService {

    PatientDto PatientSignIn(PatientDto patientSignInRequest);
    PatientDto PatientSignUp(PatientDto patientSignUnRequest);
    PatientDto BookAppointment(PatientDto patientBookAppointmentRequest);
    PatientDto RescheduleAppointment(PatientDto patientRescheduleAppointmentRequest);
    PatientDto GetPatientAppointmentDetails(Long patientAppointmentId);
}
