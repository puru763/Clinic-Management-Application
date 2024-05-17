package com.ClinicManagementApplication.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentDTO {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private String description;
    private String appointmentDate;

}
