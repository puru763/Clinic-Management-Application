package com.ClinicManagementApplication.doctorservice.service;

import com.ClinicManagementApplication.doctorservice.entity.Doctor;
import com.ClinicManagementApplication.doctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;


@Service
public class DoctorServiceImpl implements  DoctorService{


    private final DoctorRepository doctorRepository;
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor registerDoctor(Doctor doctor) {
        doctor.setDoctorId(generateUniqueDoctortId());
        return doctorRepository.save(doctor);
    }
    private Long generateUniqueDoctortId() {
        Random random = new Random();
        return random.nextInt(90000000) + 10000000L;
    }
}
