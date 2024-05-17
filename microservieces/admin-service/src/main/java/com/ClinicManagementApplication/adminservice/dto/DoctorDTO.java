package com.ClinicManagementApplication.adminservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO {

    private Long doctorId;
    private String name;
    private int yearsOfExperience;
    private String speciality;

}