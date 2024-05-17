package com.ClinicManagementApplication.patientservice.client;


import com.ClinicManagementApplication.patientservice.entity.Appointment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "doctor-service")
public interface DoctorServiceClient {
    @PostMapping("/doctors/{doctorId}/appointments")
    void addAppointmentToDoctor(@PathVariable Long doctorId, @RequestBody Appointment appointment);
}
