package com.ClinicManagementApplication.adminservice.client;

import com.ClinicManagementApplication.adminservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FeignClient(name = "ADMIN-SERVICE")
public interface PatientServiceClient {
    @GetMapping("/api/v1/patient/get-all-patients")
    List<PatientDTO> getAllPatients(RestTemplate restTemplate);
}