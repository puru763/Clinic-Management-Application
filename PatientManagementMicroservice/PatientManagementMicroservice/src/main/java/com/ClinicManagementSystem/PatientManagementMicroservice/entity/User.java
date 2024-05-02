package com.ClinicManagementSystem.PatientManagementMicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;

}