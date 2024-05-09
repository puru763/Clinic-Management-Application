package com.ClinicManagementApplication.patientservice.service;


import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.repository.PatientRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.Optional;


@Service
public class PatientServiceImpl  implements   PatientService {


    @Autowired
    private PatientRepository patientRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Override
    public Patient registerPatient(Patient patient) {
        try{
            Optional<Patient> existingPatient= patientRepository.findByMobileNumber(patient.getMobileNumber());
            if(existingPatient.isPresent()) {return null;}
            else {
                patientRepository.save(patient);
                return patient;
            }
        }catch(Exception e){
            LOGGER.error("Error occurred during patient registration: " + e.getMessage());
            throw new RuntimeException("Failed to register patient. Please try again.");
        }

    }
}
