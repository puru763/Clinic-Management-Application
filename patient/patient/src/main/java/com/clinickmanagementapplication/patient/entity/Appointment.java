package com.clinickmanagementapplication.patient.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;

    private String date;

    private String time;

    private String place;

    private String description;
}