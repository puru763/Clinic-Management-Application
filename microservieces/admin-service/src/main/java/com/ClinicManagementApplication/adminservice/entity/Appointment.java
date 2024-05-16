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
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Long patientId;

    private Long doctorId;
    private String description;

}
