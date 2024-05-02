package com.ClinicManagementSystem.PatientManagementMicroservice.dto;

import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import lombok.Data;

import java.util.Date;
@Data
public class AppointmentDTO {
    private Long id;
    private Date appointmentDate;
    private String appointmentTime;
    private String appointmentDescription;

}
