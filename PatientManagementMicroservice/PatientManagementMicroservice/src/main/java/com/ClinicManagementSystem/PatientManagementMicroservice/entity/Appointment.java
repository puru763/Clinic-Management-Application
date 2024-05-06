package com.ClinicManagementSystem.PatientManagementMicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date appointmentDate;
    private String appointmentTime;
    private String appointmentDescription;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
