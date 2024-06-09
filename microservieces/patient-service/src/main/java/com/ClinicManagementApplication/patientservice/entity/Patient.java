package com.ClinicManagementApplication.patientservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    private Long patientId;

    @NotNull(message = "Mobile number cannot be null")
    @Size(min = 10, max = 10, message = "Mobile number must be 10 digits")
    @Column(unique = true)
    private String mobileNumber;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Appointment> appointments;
}
