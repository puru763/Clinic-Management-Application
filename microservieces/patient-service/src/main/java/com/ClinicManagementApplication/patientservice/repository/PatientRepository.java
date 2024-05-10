package com.ClinicManagementApplication.patientservice.repository;

import com.ClinicManagementApplication.patientservice.dto.AppointmentDTO;
import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
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

    List<Patient> findAll();

    @Query("SELECT p FROM Patient p JOIN FETCH p.appointments WHERE p.patientId = :patientId")
    Optional<Patient> findPatientWithAppointments(@Param("patientId") Long patientId);


}
