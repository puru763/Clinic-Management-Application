package com.ClinicManagementApplication.patientservice.dto;

import com.ClinicManagementApplication.patientservice.entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class PatientDTO {
    private Long patientId;
    private String mobileNumber;
    private String password;
    private List<Appointment> appointments;


}