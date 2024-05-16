package com.ClinicManagementApplication.adminservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private Long appointmentId;
//    @ManyToOne
//    @JoinColumn(name = "patient_id")
    private Patient patient;
    private Long doctorId;
    private String description;

}
