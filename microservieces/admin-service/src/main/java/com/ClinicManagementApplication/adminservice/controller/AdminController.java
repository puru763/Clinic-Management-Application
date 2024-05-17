package com.ClinicManagementApplication.adminservice.controller;

import com.ClinicManagementApplication.adminservice.client.DoctorServiceClient;
import com.ClinicManagementApplication.adminservice.client.PatientServiceClient;
import com.ClinicManagementApplication.adminservice.dto.AppointmentDTO;
import com.ClinicManagementApplication.adminservice.dto.DoctorDTO;
import com.ClinicManagementApplication.adminservice.dto.PatientDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final PatientServiceClient patientServiceClient;

    private final DoctorServiceClient doctorServiceClient;

    public AdminController(PatientServiceClient patientServiceClient, DoctorServiceClient doctorServiceClient) {
        this.patientServiceClient = patientServiceClient;
        this.doctorServiceClient = doctorServiceClient;
    }


    @GetMapping("/get-patient-by-patientId/{patientId}")
    public PatientDTO getPatientByPatientId(@PathVariable Long patientId) {
        return patientServiceClient.getPatientByPatientId(patientId);
    }


    @GetMapping("/get-all-patients")
    public List<PatientDTO> getAllPatients() {
        return patientServiceClient.getAllPatients();
    }


    @GetMapping("/get-all-appointments")
    public List<AppointmentDTO> getAllAppointments() {
            return patientServiceClient.getAllAppointments();
    }


    @GetMapping("/get-doctor-by-doctorId/{doctorId}")
    public DoctorDTO getDoctorBydoctorId(@PathVariable Long doctorId) {
        return doctorServiceClient.getDoctorBydoctorId(doctorId);
    }


    @GetMapping("/get-all-doctors")
    public List<DoctorDTO> getAllDoctors() {
        return doctorServiceClient.getAllDoctors();
    }

}


