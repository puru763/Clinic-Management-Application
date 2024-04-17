package com.ClinicManagementSystem.PatientManagementMicroservice.entity;

@Data
@Entity
@Table(name ="Patient")
public class PatientEntity {


    @Id
    private Long id;

    private String fname;

    private String lname;

    private String mobile;

    private String password;
}
