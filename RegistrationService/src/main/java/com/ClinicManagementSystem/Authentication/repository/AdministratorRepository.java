//package com.ClinicManagementSystem.Authentication.repository;
//
//import org.apache.catalina.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface AdministratorRepository extends JpaRepository<User, String> {
//}


package com.ClinicManagementSystem.Authentication.repository;

import com.ClinicManagementSystem.Authentication.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<AdministratorEntity, String> {
}
