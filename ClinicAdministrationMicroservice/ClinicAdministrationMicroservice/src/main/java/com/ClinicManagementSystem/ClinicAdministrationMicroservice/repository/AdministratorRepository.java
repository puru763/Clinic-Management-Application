

package com.ClinicManagementSystem.ClinicAdministrationMicroservice;

import com.ClinicManagementSystem.Authentication.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<AdministratorEntity, String> {
}
