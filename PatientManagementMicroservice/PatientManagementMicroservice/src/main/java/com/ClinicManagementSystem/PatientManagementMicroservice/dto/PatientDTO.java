package com.ClinicManagementSystem.PatientManagementMicroservice.dto;

import com.ClinicManagementSystem.PatientManagementMicroservice.entity.Patient;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String password;
    private List<AppointmentDTO> appointments;





}

