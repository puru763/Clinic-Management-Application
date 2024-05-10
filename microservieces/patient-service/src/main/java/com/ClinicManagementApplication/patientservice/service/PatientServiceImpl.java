package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.repository.PatientRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl  implements   PatientService {

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

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

    @Override
    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        Optional<Patient> patientOpt = patientRepository.findPatientWithAppointments(patientId);
        if (patientOpt.isPresent()) {
            return patientOpt.get().getAppointments();
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> new PatientDTO(patient.getPatientId(), patient.getMobileNumber(), patient.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientByPatientId(Long patientId) {
        try {
            Optional<Patient> patientOpt = patientRepository.findById(patientId);
            if (patientOpt.isPresent()) {
                Patient patient = patientOpt.get();
                return new PatientDTO(patient.getPatientId(), patient.getMobileNumber(), patient.getPassword());
            } else {
                LOGGER.warn("Patient not found for ID: " + patientId);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching patient: " + e.getMessage());
            throw new RuntimeException("Failed to fetch patient");
        }
    }

}
