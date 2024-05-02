package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import com.ClinicManagementSystem.PatientManagementMicroservice.repository.AppoimentRepository;
import com.ClinicManagementSystem.PatientManagementMicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AppoimentServiceImpl implements AppoimentService {

    @Autowired
    private AppoimentRepository appoimentRepository;

    @Autowired
    private PatientRepository patientRepository;




    public Appointment bookAppointment(Appointment bookingRequest) {
        Long patientId = bookingRequest.getPatientId();
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctorName(bookingRequest.getDoctorName());
        appointment.setAppointmentDate(bookingRequest.getAppointmentDate());
        appointment.setAppointmentTime(bookingRequest.getAppointmentTime());
        appointment.setVenue(bookingRequest.getVenue());

        appointment.setDiagnosis(bookingRequest.getDiagnosis());
        return appointment;
    }

    @Override
    public PatientAppointmentDto rescheduleAppointment(Long appointmentId, Appointment bookingRequest) {
        Appointment appointment = appoimentRepository.findById(appointmentId).orElseThrow();
        appointment.setAppointmentDate(bookingRequest.getAppointmentDate());
        appointment.setAppointmentTime(bookingRequest.getAppointmentTime());
        appointment.setVenue(bookingRequest.getVenue());
        appoimentRepository.save(appointment);
        return new PatientAppointmentDto(appointment);
    }


    @Override
    public void deleteAppointment(Long appointmentId) {
        appoimentRepository.deleteById(appointmentId);
    }


}
