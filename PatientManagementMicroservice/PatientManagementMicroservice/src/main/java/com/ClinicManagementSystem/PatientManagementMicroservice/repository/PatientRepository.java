package com.ClinicManagementSystem.PatientManagementMicroservice.repository;

import com.ClinicManagementSystem.PatientManagementMicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}