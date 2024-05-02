package com.ClinicManagementSystem.PatientManagementMicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentDto {
    private Long bookingId;
    private Long patientId;
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;
    private String venue;
    private String diagnosis;
}
