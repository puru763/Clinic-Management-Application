package com.ClinicManagementApplication.doctorservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AppointmentDTO {
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private String description;

}