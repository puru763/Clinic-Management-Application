package com.ClinicManagementSystem.PatientManagementMicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long bookingId;
    private Long patientId;
    private String doctorName;
    private String appointmentDate;
    private String appointmentTime;
    private String venue;
    private String diagnosis;

}
