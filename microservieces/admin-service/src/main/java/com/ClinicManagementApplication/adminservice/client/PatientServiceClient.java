package com.ClinicManagementApplication.adminservice.client;

import com.ClinicManagementApplication.adminservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PATIENT-SERVICE",url = "${eureka.client.service-url.defaultZone}")
public interface PatientServiceClient {

    @GetMapping("/api/v1/patient/get-all-patients")
    List<PatientDTO> getAllPatients();
}