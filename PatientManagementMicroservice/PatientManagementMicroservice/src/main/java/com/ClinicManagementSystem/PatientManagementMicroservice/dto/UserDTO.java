package com.ClinicManagementSystem.PatientManagementMicroservice.dto;

import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Appointment;
import com.ClinicManagementSystem.PatientManagementMicroservice.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class UserDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String password;
    private List<AppointmentDTO> appointments;
}

