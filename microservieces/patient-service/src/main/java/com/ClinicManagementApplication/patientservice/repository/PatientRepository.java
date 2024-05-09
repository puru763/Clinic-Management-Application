package com.ClinicManagementApplication.patientservice.repository;

import com.ClinicManagementApplication.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByMobileNumber(String mobileNumber);
}
