package com.ClinicManagementApplication.adminservice.entity;


import com.ClinicManagementApplication.patientservice.entity.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private Long patientId;

    @Size(min = 10, max = 10)
    private String mobileNumber;
    private String password;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Exclude appointments from serialization
    private List<Appointment> appointments = new ArrayList<>();

    @PrePersist
    private void generateId() {
        long timestamp = Instant.now().getEpochSecond();
        int randomNumber = (int) (Math.random() * 900000) + 100000;
        Long generatedId = Long.valueOf(timestamp * 1000000 + randomNumber);
        this.patientId = generatedId;
    }
}
