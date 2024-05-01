package com.ClinicManagementSystem.PatientManagementMicroservice.repository;

import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,String> {
}
