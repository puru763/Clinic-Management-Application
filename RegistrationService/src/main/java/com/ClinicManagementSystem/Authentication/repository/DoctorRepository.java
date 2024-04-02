package com.ClinicManagementSystem.Authentication.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository   extends  JpaRepository<User, String>{
}
