package com.ClinicManagementApplication.patientservice.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.repository.AppointmentRepository;
import com.ClinicManagementApplication.patientservice.repository.PatientRepository;
import java.util.Optional;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentServiceImpl.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        try {
            Long patientId = appointment.getPatient().getPatientId();
            Optional<Patient> existingPatient = patientRepository.findById(patientId);
            if (!existingPatient.isPresent()) {
                LOGGER.error("Patient not found for ID: " + patientId);
                return null;
            }

            Patient patient = existingPatient.get();
            appointment.setPatient(patient);
            patient.getAppointments().add(appointment);

            Appointment bookedAppointment = appointmentRepository.save(appointment);

            return bookedAppointment;
        } catch (Exception e) {
            LOGGER.error("Error booking appointment: " + e.getMessage());
            throw new RuntimeException("Failed to book appointment. Please try again.");
        }
    }
}
