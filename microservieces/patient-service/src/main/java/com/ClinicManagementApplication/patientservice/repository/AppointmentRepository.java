package com.ClinicManagementApplication.patientservice.repository;

import com.ClinicManagementApplication.patientservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByAppointmentId(Long appointmentId);
    List<Appointment> findAll();

}

