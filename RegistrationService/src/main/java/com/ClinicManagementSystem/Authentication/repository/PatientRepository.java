package com.ClinicManagementSystem.Authentication.repository;

import com.ClinicManagementSystem.Authentication.entity.PatientEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, String> {
}
