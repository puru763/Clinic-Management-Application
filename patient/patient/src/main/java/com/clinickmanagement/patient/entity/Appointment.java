package com.clinickmanagement.patient.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {
    @Id
    private Long appointmentId;

    @Column(name = "patient_id") // Corrected the column name
    private Long patientId;

    @ManyToOne
    @JoinColumn(name = "patient_id") // Corrected the column name
    private Patient patient;

    private Long doctorId;
    private String description;

    @PrePersist
    private void generateId() {
        long timestamp = Instant.now().getEpochSecond();
        int randomNumber = (int) (Math.random() * 900000) + 100000;
        Long generatedId = Long.valueOf(timestamp * 1000000 + randomNumber);
        this.appointmentId = generatedId;
    }
}
