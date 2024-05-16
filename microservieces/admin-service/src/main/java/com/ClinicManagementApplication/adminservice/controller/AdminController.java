package com.ClinicManagementApplication.adminservice.controller;

import com.ClinicManagementApplication.adminservice.client.PatientServiceClient;
import com.ClinicManagementApplication.adminservice.dto.PatientDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final PatientServiceClient patientServiceClient;
    private final RestTemplate restTemplate;

    public AdminController(PatientServiceClient patientServiceClient, RestTemplate restTemplate) {
        this.patientServiceClient = patientServiceClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get-all-patients")
    public List<PatientDTO> getAllPatients() {
        return patientServiceClient.getAllPatients(restTemplate);
    }
}



//    @GetMapping("/get-all-appointments")
//    public List<AppointmentDTO> getAllAppointments() {
//       return null;
//
//    }
//
//    @GetMapping("/get-appointment-by-appointmentid/{appointmentId}")
//    public AppointmentDTO getAppointmentByAppointmentId(@PathVariable Long appointmentId) {
//        return null;
//    }
//
//    @GetMapping("/get-patient-by-patientid/{patientId}")
//    public PatientDTO getPatientByPatientId(@PathVariable Long patientId) {
//       return null;
//    }