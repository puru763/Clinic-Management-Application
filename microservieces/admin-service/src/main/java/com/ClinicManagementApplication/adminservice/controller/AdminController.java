package com.ClinicManagementApplication.adminservice.controller;

import com.ClinicManagementApplication.adminservice.dto.AppointmentDTO;
import com.ClinicManagementApplication.adminservice.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${patient.service.url}")
    private String patientServiceUrl;



    @GetMapping("/get-all-patients")
    public List<PatientDTO> getAllPatients() {
        ResponseEntity<List<PatientDTO>> response = restTemplate.exchange(
                "http://localhost:8080/patient-service/patients",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PatientDTO>>() {}
        );

        return response.getBody();
    }

    @GetMapping("/get-all-appointments")
    public List<AppointmentDTO> getAllAppointments() {
        ResponseEntity<List<AppointmentDTO>> response = restTemplate.exchange(
                "http://localhost:8080/patient-service/appointments",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AppointmentDTO>>() {}
        );

        return response.getBody();
    }

    @GetMapping("/get-appointment-by-appointmentid/{appointmentId}")
    public AppointmentDTO getAppointmentByAppointmentId(@PathVariable Long appointmentId) {
        ResponseEntity<AppointmentDTO> response = restTemplate.exchange(
                "http://localhost:8080/patient-service/appointments/" + appointmentId,
                HttpMethod.GET,
                null,
                AppointmentDTO.class
        );

        return response.getBody();
    }

    @GetMapping("/get-patient-by-patientid/{patientId}")
    public PatientDTO getPatientByPatientId(@PathVariable Long patientId) {
        ResponseEntity<PatientDTO> response = restTemplate.exchange(
                "http://localhost:8080/patient-service/patients/" + patientId,
                HttpMethod.GET,
                null,
                PatientDTO.class
        );

        return response.getBody();
    }
}
