package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient registerPatient(Patient patient);
    public List<Appointment> getAppointmentsForPatient(Long patientId);


}
