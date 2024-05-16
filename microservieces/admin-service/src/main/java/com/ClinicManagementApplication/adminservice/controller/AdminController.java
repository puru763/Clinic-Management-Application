package com.ClinicManagementApplication.adminservice.controller;

import com.ClinicManagementApplication.adminservice.client.PatientServiceClient;
import com.ClinicManagementApplication.adminservice.dto.AppointmentDTO;
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

    public AdminController(PatientServiceClient patientServiceClient) {
        this.patientServiceClient = patientServiceClient;
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
