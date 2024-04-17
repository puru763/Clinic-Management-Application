package com.ClinicManagementSystem.ClinicAdministrationMicroservice;

public class AdministratorDto {
    private final String number;
    private final String password;

    public AdministratorDto(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}
