
package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientDTO getPatientByPatientId(Long patientId);
    List<PatientDTO> getAllPatients();

    Patient registerPatient(@Valid @RequestBody Patient patient, BindingResult result);

    Optional<Patient> findByMobileNumber(String mobileNumber);
    Appointment bookAppointment(Long patientId, Appointment appointment);
    Appointment bookAppointment(Long patientId, Long doctorId, Appointment appointment);
}
