package com.ClinicManagementSystem.PatientManagementMicroservice.repository;

import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppoimentRepository extends JpaRepository<Appointment, Long> {
}
