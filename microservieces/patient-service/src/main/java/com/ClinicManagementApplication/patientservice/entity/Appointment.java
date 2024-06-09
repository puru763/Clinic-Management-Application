package com.ClinicManagementApplication.patientservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @NotNull(message = "Doctor ID cannot be null")
    private Long doctorId;

    @NotBlank(message = "Details cannot be blank")
    private String details;

    @NotBlank(message = "Appointment date cannot be blank")
    private String appointmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @NotNull(message = "Patient cannot be null")
    private Patient patient;
}
