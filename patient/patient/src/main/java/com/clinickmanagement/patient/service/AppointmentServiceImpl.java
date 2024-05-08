package com.clinickmanagement.patient.service;

import com.clinickmanagement.patient.entity.Appointment;
import com.clinickmanagement.patient.entity.Patient;
import com.clinickmanagement.patient.repository.AppointmentRepository;
import com.clinickmanagement.patient.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AppointmentServiceImpl  implements  AppointmentService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(Appointment appointment) {
        try {
            Patient patient = patientRepository.findById(appointment.getPatientId())
                    .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + appointment.getPatientId()));

            Appointment bookedAppointment = new Appointment();
            bookedAppointment.setDescription(appointment.getDescription());
            bookedAppointment.setDoctorId(appointment.getDoctorId());
            bookedAppointment.setPatient(patient);

            appointmentRepository.save(bookedAppointment);

            List<Appointment> appointments = patient.getAppointments();
            appointments.add(bookedAppointment);
            patient.setAppointments(appointments);

            patientRepository.save(patient);

            return appointment;
        } catch (EntityNotFoundException e) {
            // Handle the case when the patient is not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            // Handle any other exceptions that may occur
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while booking appointment", e);
        }
    }
}


//    @Override
//    public Appointment bookAppointment(Appointment appointment) {
//        try {
//             appointmentRepository.save(appointment);
//             return appointment;
//        } catch (Exception e) {
//            LOGGER.error("Error occurred during booking an appointment: " + e.getMessage());
//            throw new RuntimeException("Failed to book an appointment. Please try again.");
//        }
//    }