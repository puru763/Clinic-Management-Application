package com.ClinicManagementApplication.patientservice.service;

import com.ClinicManagementApplication.patientservice.client.DoctorServiceClient;
import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private DoctorServiceClient doctorFeignClient;

    public PatientServiceImpl(PatientRepository patientRepository, DoctorServiceClient doctorFeignClient) {
        this.patientRepository = patientRepository;
        this.doctorFeignClient = doctorFeignClient;
    }


    @Override
    public Appointment bookAppointment(Long patientId, Long doctorId, Appointment appointment) {
        try {
            return patientRepository.findById(patientId).map(patient -> {
                appointment.setPatient(patient);
                appointment.setAppointmentId(generateUniqueAppointId());
                patient.getAppointments().clear();
                patient.getAppointments().add(appointment);
                patientRepository.save(patient);

                doctorFeignClient.addAppointmentToDoctor(doctorId, appointment);

                return appointment;
            }).orElseThrow(() -> new RuntimeException("Patient not found"));
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding appointment: " + e.getMessage());
            throw new RuntimeException("Failed to add appointment");
        }
    }
    private Long generateUniqueAppointId() {
        Random random = new Random();
        return random.nextInt(90000000) + 10000000L;
    }


    @Override
    public Patient registerPatient(Patient patient) {
        try {
            Optional<Patient> existingPatient = patientRepository.findByMobileNumber(patient.getMobileNumber());

            if (existingPatient.isPresent()) {
                return null;
            } else {
                Long generatedPatientId = generateUniquePatientId();
                patient.setPatientId(generatedPatientId);
                patient.setAppointments(new ArrayList<>()); // Ensure the appointments list is empty
                return patientRepository.save(patient);
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred during patient registration: {}", e.getMessage());
            throw new RuntimeException("Failed to register patient. Please try again.", e);
        }
    }
    @Override
    public Optional<Patient> findByMobileNumber(String mobileNumber) {
        return patientRepository.findByMobileNumber(mobileNumber);
    }
    @Override
    public Appointment bookAppointment(Long patientId, Appointment appointment) {
        return null;
    }
    private Long generateUniquePatientId() {
        Random random = new Random();
        return random.nextInt(90000000) + 10000000L;
    }



    @Override
    public PatientDTO getPatientByPatientId(Long patientId) {
        try {
            Optional<Patient> patientOpt = patientRepository.findById(patientId);
            if (patientOpt.isPresent()) {
                Patient patient = patientOpt.get();
                return new PatientDTO(patient.getPatientId(), patient.getMobileNumber(), patient.getPassword(), patient.getAppointments());
            } else {
                LOGGER.warn("Patient not found for ID: " + patientId);
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching patient: " + e.getMessage());
            throw new RuntimeException("Failed to fetch patient");
        }
    }



    @Override
    public List<PatientDTO> getAllPatients() {
        try {
            return patientRepository.findAll().stream()
                    .map(patient -> new PatientDTO(patient.getPatientId(), patient.getMobileNumber(), patient.getPassword(),patient.getAppointments()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.error("An error occurred while retrieving all patients", e);
            throw new RuntimeException("An error occurred while retrieving patients", e);
        }
    }

}
