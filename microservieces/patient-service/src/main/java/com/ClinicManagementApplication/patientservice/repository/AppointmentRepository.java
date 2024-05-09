package com.ClinicManagementApplication.patientservice.repository;

import com.ClinicManagementApplication.patientservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
