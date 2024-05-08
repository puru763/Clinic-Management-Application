package com.clinickmanagement.patient.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "patient")
public class Patient {
    @Id
    private Long patientId;

    @Size(min = 10, max = 10)
    private String mobileNumber;
    private String password;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();

    @PrePersist
    private void generateId() {
        long timestamp = Instant.now().getEpochSecond();
        int randomNumber = (int) (Math.random() * 900000) + 100000;
        Long generatedId = Long.valueOf(timestamp * 1000000 + randomNumber);
        this.patientId = generatedId;
    }
}
