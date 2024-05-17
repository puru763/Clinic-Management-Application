package com.ClinicManagementApplication.patientservice.repository;


import com.ClinicManagementApplication.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByMobileNumber(String mobileNumber);
    Optional<Patient> findById(Long  patientId);

}
