package com.ClinicManagementSystem.Authentication.repository;

import com.ClinicManagementSystem.Authentication.entity.DoctorEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository   extends  JpaRepository<DoctorEntity, String>{
}
