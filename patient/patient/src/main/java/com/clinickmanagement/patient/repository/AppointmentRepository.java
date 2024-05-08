package com.clinickmanagement.patient.repository;

import com.clinickmanagement.patient.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
