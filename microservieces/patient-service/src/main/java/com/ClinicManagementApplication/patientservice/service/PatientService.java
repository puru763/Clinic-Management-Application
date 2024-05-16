package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient registerPatient(Patient patient);

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientByPatientId(Long patientId);
}