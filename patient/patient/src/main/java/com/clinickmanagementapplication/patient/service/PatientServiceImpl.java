package com.clinickmanagementapplication.patient.service;

import com.clinickmanagementapplication.patient.entity.Patient;
import com.clinickmanagementapplication.patient.repository.PatientRepository;
import org.hibernate.HibernateException;

import java.util.Optional;

public class PatientServiceImpl implements PatientService{

    @Override
    public Patient RegisterPatient(Patient patient) {
        try {
            Optional<Patient> existingPatient = PatientRepository.findByMobileNumber(patient.getMobileNumber());
            if (existingPatient.isPresent()) {
                return existingPatient.get();
            } else {
                PatientRepository.save(patient);
                return patient;
            }
        } catch (NullPointerException e) {
            if (PatientRepository.findByMobileNumber(patient.getMobileNumber()).isPresent()) {
                return PatientRepository.findByMobileNumber(patient.getMobileNumber()).get();
            } else {
                throw new RuntimeException("Patient object is null", e);
            }
        } catch (HibernateException e) {
            if (PatientRepository.findByMobileNumber(patient.getMobileNumber()).isPresent()) {
                return PatientRepository.findByMobileNumber(patient.getMobileNumber()).get();
            } else {
                throw new RuntimeException("Patient  is   alreday registered ", e);
            }
        }
    }
}
