package com.ClinicManagementApplication.doctorservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @NotNull(message = "Patient ID cannot be null")
    private Long patientId;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonIgnoreProperties("appointments")

    private Doctor doctor;
}
