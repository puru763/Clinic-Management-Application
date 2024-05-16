package com.ClinicManagementApplication.patientservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {

    @Id
    private Long appointmentId;

    @OneToOne
    @JoinColumn(name = "patient_id", unique = true)
    private Patient patient;

    private Long doctorId;
    private String description;
}

