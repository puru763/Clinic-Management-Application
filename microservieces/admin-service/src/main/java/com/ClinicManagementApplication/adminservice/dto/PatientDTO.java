package com.ClinicManagementApplication.adminservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientDTO {
    private Long patientId;
    private String mobileNumber;
    private String password;
}