package com.ClinicManagementApplication.adminservice.client;

import com.ClinicManagementApplication.adminservice.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@FeignClient(name = "DOCTOR-SERVICE/api/v1/doctor")
public interface DoctorServiceClient {

    @GetMapping("/get-all-doctors")
    List<DoctorDTO> getAllDoctors();

    @GetMapping("/get-doctor-by-doctorId/{doctorId}")
    DoctorDTO getDoctorBydoctorId(@PathVariable Long doctorId);

}
