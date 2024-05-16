package com.ClinicManagementApplication.patientservice.repository;

import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByPatientId(Long patientId);

    boolean existsByPatient(Patient patient);

    List<Appointment> findByPatientId(Long patientId);
}

