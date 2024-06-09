package com.ClinicManagementApplication.doctorservice.controller;

import com.ClinicManagementApplication.doctorservice.dto.DoctorDTO;
import com.ClinicManagementApplication.doctorservice.entity.Appointment;
import com.ClinicManagementApplication.doctorservice.entity.Doctor;
import com.ClinicManagementApplication.doctorservice.repository.DoctorRepository;
import com.ClinicManagementApplication.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {


    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;


    @Autowired
    public DoctorController(DoctorRepository doctorRepository, DoctorService doctorService) {
        this.doctorRepository = doctorRepository;
        this.doctorService = doctorService;
    }

    @PostMapping("/register-doctor")
    public ResponseEntity<?> registerDoctor(@RequestBody Doctor doctor) {
        try {
            Doctor registeredDoctor = doctorService.registerDoctor(doctor);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredDoctor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering doctor: " + e.getMessage());
        }
    }

    @GetMapping("/get-all-doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        try {
            List<Doctor> doctors = doctorRepository.findAll();
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }


    @GetMapping("/appointments/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        try {
            Doctor doctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));

            List<Appointment> appointments = doctor.getAppointments();
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }


    @GetMapping("/get-doctor-by-doctorId/{doctorId}")
    public ResponseEntity<DoctorDTO> getDoctorByDoctorId(@PathVariable Long doctorId) {
        try {
            Doctor doctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));

            DoctorDTO doctorDTO = new DoctorDTO();
            doctorDTO.setDoctorId(doctor.getDoctorId());
            doctorDTO.setName(doctor.getName());
            doctorDTO.setYearsOfExperience(doctor.getYearsOfExperience());
            doctorDTO.setSpeciality(doctor.getSpeciality());

            return ResponseEntity.ok(doctorDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
