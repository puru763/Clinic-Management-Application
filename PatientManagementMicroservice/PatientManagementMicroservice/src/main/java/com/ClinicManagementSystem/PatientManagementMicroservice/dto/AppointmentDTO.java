package com.ClinicManagementSystem.PatientManagementMicroservice.dto;

import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    private Date appointmentDate;
    private String appointmentTime;
    private String appointmentDescription;

}
