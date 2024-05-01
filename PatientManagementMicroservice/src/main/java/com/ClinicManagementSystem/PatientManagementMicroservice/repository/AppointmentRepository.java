package com.ClinicManagementSystem.PatientManagementMicroservice.repository;



import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {



    Optional<Appointment> findById(Long id);

}
