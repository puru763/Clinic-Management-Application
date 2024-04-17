package com.ClinicManagementSystem.Authentication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="Doctor")
public class DoctorEntity {


    @Id
    private Long id;

    private String fname;

    private String lname;

    private String mobile;

    private String password;
}
