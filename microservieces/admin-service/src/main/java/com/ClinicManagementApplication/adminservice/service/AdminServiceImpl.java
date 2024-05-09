package com.ClinicManagementApplication.adminservice.service;

import com.ClinicManagementApplication.adminservice.config.PatientProps;
import org.springframework.web.reactive.function.client.WebClient;

public class AdminServiceImpl implements  AdminService{



    private PatientProps patientProps;
    private WebClient webClient;

    public AdminServiceImpl(PatientProps patientProps, WebClient webClient) {
        this.patientProps = patientProps;
        this.webClient = webClient;
    }




}
