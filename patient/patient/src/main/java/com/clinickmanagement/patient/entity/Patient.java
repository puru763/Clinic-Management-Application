package com.clinickmanagement.patient.entity;

import jakarta.persistence.*;
import java.math.BigInteger;
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
@Table(name = "patient")
public class Patient {

    @Id
    @Column(columnDefinition = "BIGINT")
    private BigInteger id;

    @Size(min = 10, max = 10)
    private String mobileNumber;
    private String password;

    @PrePersist
    private void generateId() {
        long timestamp = Instant.now().getEpochSecond();
        int randomNumber = (int) (Math.random() * 900000) + 100000;
        BigInteger generatedId = BigInteger.valueOf(timestamp * 1000000 + randomNumber);
        this.id = generatedId;
    }
}
