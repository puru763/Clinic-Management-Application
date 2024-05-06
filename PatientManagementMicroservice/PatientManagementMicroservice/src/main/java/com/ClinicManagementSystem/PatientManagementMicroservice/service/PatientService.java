package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientDTO;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;

import java.util.List;

public interface PatientService {


    Patient RegisterPatient(Patient patient);
}