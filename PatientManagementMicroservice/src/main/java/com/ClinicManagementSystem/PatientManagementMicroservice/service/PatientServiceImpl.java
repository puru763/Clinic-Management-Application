package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.PatientAppointmentDto;

public class PatientServiceImpl  implements PatientService {


    @Override
    public PatientAppointmentDto bookAppointment(PatientAppointmentDto bookingRequest) {

        return bookingRequest;
    }

    @Override
    public PatientAppointmentDto rescheduleAppointment(Long appointmentId, PatientAppointmentDto bookingRequest) {

        return bookingRequest;
    }


    @Override
    public PatientAppointmentDto getPatientAppointmentDetails(Long appointmentId) {
        return null;
    }

    @Override
    public void deleteAppointment(Long appointmentId) {

    }
}
