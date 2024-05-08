package com.clinickmanagement.patient.service;

import com.clinickmanagement.patient.entity.Patient;
import com.clinickmanagement.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Override
    public Patient registerPatient(Patient patient) {
        try {
            Optional<Patient> existingPatient = patientRepository.findByMobileNumber(patient.getMobileNumber());
            if (existingPatient.isPresent()) {
                return null;
            } else {
                patientRepository.save(patient);
                return patient;
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred during patient registration: " + e.getMessage());
            throw new RuntimeException("Failed to register patient. Please try again.");
        }
    }
}










