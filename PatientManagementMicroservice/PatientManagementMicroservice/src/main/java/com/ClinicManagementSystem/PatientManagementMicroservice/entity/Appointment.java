package com.ClinicManagementSystem.PatientManagementMicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date appointmentDate;
    private String appointmentTime;
    private String appointmentDescription;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
