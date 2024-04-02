package com.ClinicManagementSystem.Authentication.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<User, String> {
}
