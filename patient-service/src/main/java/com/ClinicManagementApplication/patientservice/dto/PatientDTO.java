package com.ClinicManagementApplication.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class PatientDTO {
    private Long patientId;
    private String mobileNumber;
    private String password;


}