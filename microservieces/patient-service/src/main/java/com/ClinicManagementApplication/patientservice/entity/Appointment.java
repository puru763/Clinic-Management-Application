
package com.ClinicManagementApplication.patientservice.entity;

import jakarta.persistence.*;
import java.time.Instant;

import jakarta.validation.constraints.Size;
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

    @ManyToOne
    @JoinColumn(name = "patient_id")
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
