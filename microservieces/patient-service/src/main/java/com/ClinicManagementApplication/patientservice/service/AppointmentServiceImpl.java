package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.dto.AppointmentDTO;
import com.ClinicManagementApplication.patientservice.exception.BookingException;
import com.ClinicManagementApplication.patientservice.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.repository.AppointmentRepository;
import com.ClinicManagementApplication.patientservice.repository.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentServiceImpl.class);

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }


    @Override
    public Appointment bookAppointment(Appointment appointment) {
        Long patientId = appointment.getPatient().getPatientId();
        Optional<Patient> patientOpt = patientRepository.findById(patientId);

        if (patientOpt.isEmpty()) {
            LOGGER.error("Patient not found for ID: {}", patientId);
            throw new NotFoundException("Patient not found");
        }

        try {
            appointment.setPatient(patientOpt.get());
            return appointmentRepository.save(appointment);
        } catch (Exception e) {
            LOGGER.error("Error booking appointment", e);
            throw new BookingException("Failed to book appointment", e);
        }
    }



    @Override
    public Optional<AppointmentDTO> getAppointmentByAppointmentId(Long appointmentId) {
        try {
            return appointmentRepository.findById(appointmentId)
                    .map(appointment -> new AppointmentDTO(
                            appointment.getAppointmentId(),
                            appointment.getPatient().getPatientId(),
                            appointment.getDoctorId(),
                            appointment.getDescription()));
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching appointment", e);
            throw new BookingException("Failed to fetch appointment", e);
        }
    }


    @Override
    public List<AppointmentDTO> getAllAppointments() {
        try {
            List<Appointment> appointments = appointmentRepository.findAll();
            return appointments.stream()
                    .map(appointment -> new AppointmentDTO(appointment.getAppointmentId(), appointment.getPatientId(), appointment.getDoctorId(), appointment.getDescription()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching appointments: " + e.getMessage());
            throw new RuntimeException("Failed to fetch appointments");
        }
    }

}
