
package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient registerPatient(Patient patient);
    PatientDTO getPatientByPatientId(Long patientId);
    List<PatientDTO> getAllPatients();
    Optional<Patient> findByMobileNumber(String mobileNumber);
    Appointment bookAppointment(Long patientId, Appointment appointment);
    public Appointment bookAppointment(Long patientId, Long doctorId, Appointment appointment);

    }
