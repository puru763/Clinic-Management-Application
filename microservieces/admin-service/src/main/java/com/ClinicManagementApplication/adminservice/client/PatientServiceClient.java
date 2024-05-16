package com.ClinicManagementApplication.adminservice.client;

import com.ClinicManagementApplication.adminservice.dto.AppointmentDTO;
import com.ClinicManagementApplication.adminservice.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PATIENT-SERVICE/api/v1/patient")
public interface PatientServiceClient {

    @GetMapping("/get-all-patients")
    List<PatientDTO> getAllPatients();


    @GetMapping("/get-patient-by-patientId/{patientId}")
    PatientDTO getPatientByPatientId(@PathVariable Long patientId);

    @GetMapping("/get-all-appointments")
    List<AppointmentDTO> getAllAppointments();
}
