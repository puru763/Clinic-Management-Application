package com.ClinicManagementSystem.PatientManagementMicroservice.dto;


import lombok.Data;

@Data
public class PatientAppointmentDto {
    private Long bookingId;
    private Long patientId;
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;
    private String venue;
    private String diagnosis;
}