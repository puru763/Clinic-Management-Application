<<<<<<< HEAD
package com.clinickmanagementapplication.patient.service;

import com.clinickmanagementapplication.patient.entity.Patient;
import com.clinickmanagementapplication.patient.exception.PatientAlreadyRegisteredException;
import com.clinickmanagementapplication.patient.repository.PatientRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient registerPatient(Patient patient) {
        Optional<Patient> existingPatient = PatientRepository.findByMobileNumber(patient.getMobileNumber());

        if (existingPatient.isPresent()) {
            throw new PatientAlreadyRegisteredException("Patient is already registered");
        } else {
            try {
                patientRepository.save(patient);
                return patient;
            } catch (DataIntegrityViolationException e) {
                throw new PatientAlreadyRegisteredException("Patient is already registered", e);
            }
        }
    }
}


=======
package com.clinickmanagementapplication.patient.service;public class PatientServiceImpl {
}
>>>>>>> parent of b7dbe10 (.)
