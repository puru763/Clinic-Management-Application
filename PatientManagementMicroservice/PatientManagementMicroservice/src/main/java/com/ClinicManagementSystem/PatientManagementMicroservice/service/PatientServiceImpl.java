package com.ClinicManagementSystem.PatientManagementMicroservice.service;


import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import com.ClinicManagementSystem.PatientManagementMicroservice.repository.AppoimentRepository;
import com.ClinicManagementSystem.PatientManagementMicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppoimentRepository appoimentRepository;


    @Override
    public Patient registerPatient(Patient patientRegistrationRequest) {
        Patient patient = new Patient();
        patient.setName(patientRegistrationRequest.getName());
        patient.setContactNumber(patientRegistrationRequest.getContactNumber());
        patient.setPassword(patientRegistrationRequest.getPassword());
        return patientRepository.save(patient);
    }

    @Override
    public PatientAppointmentDto getPatientAppointmentDetails(Long appointmentId) {
        Appointment appointment = appoimentRepository.findById(appointmentId).orElseThrow();
        PatientAppointmentDto patientAppointmentDto = new PatientAppointmentDto();
        patientAppointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        patientAppointmentDto.setAppointmentTime(appointment.getAppointmentTime());
        patientAppointmentDto.setVenue(appointment.getVenue());
        patientAppointmentDto.setDiagnosis(appointment.getDiagnosis());
        return patientAppointmentDto;
    }
}
