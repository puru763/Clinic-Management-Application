package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import com.ClinicManagementSystem.PatientManagementMicroservice.repository.AppointmentRepository;
import com.ClinicManagementSystem.PatientManagementMicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl  implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Patient registerPatient(Patient patientRegistrationRequest) {
        Patient patient = new Patient();
        patient.setName(patientRegistrationRequest.getName());
        patient.setContactNumber(patientRegistrationRequest.getContactNumber());
        patient.setPassword(patientRegistrationRequest.getPassword());
        return patientRepository.save(patient);
    }



    @Override
    public PatientAppointmentDto bookAppointment(PatientAppointmentDto bookingRequest) {

        Long patientId = bookingRequest.getPatientId();
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctorName(bookingRequest.getDoctorName());
        appointment.setAppointmentDate(bookingRequest.getAppointmentDate());
        appointment.setAppointmentTime(bookingRequest.getAppointmentTime());
        appointment.setVenue(bookingRequest.getVenue());

   appointment.setDiagnosis(bookingRequest.getDiagnosis());
        return bookingRequest;
    }



    @Override
    public PatientAppointmentDto rescheduleAppointment(Long appointmentId, PatientAppointmentDto bookingRequest) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointment.setAppointmentDate(bookingRequest.getAppointmentDate());
        appointment.setAppointmentTime(bookingRequest.getAppointmentTime());
        appointment.setVenue(bookingRequest.getVenue());
        appointmentRepository.save(appointment);
        return bookingRequest;
    }

    @Override
    public PatientAppointmentDto getPatientAppointmentDetails(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        PatientAppointmentDto patientAppointmentDto = new PatientAppointmentDto();
        patientAppointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        patientAppointmentDto.setAppointmentTime(appointment.getAppointmentTime());
        patientAppointmentDto.setVenue(appointment.getVenue());
        patientAppointmentDto.setDiagnosis(appointment.getDiagnosis());
        return patientAppointmentDto;
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }


}
