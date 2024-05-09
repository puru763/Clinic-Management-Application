package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);
}
