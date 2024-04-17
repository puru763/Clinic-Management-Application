package com.ClinicManagementSystem.ClinicAdministrationMicroservice;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="Administrator")
public class AdministratorEntity {

    @Id
    private Long id;

    private String fname;

    private String lname;

    private String mobile;

    private String password;


}
