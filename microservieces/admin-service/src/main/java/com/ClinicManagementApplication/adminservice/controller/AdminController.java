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
@RequestMapping("/api/v1/admin")
public class AdminController {



    @GetMapping("/get-all-patients")
    public List<PatientDTO> getAllPatients() {
        return null ;
    }

    @GetMapping("/get-all-appointments")
    public List<AppointmentDTO> getAllAppointments() {
       return null;

    }

    @GetMapping("/get-appointment-by-appointmentid/{appointmentId}")
    public AppointmentDTO getAppointmentByAppointmentId(@PathVariable Long appointmentId) {
        return null;
    }

    @GetMapping("/get-patient-by-patientid/{patientId}")
    public PatientDTO getPatientByPatientId(@PathVariable Long patientId) {
       return null;
    }
}
