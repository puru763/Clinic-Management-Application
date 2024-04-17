package com.ClinicManagementSystem.Authentication.controller;


import com.ClinicManagementSystem.Authentication.dto.AdministratorDto;
import com.ClinicManagementSystem.Authentication.dto.DoctorDto;
import com.ClinicManagementSystem.Authentication.entity.DoctorEntity;
import com.ClinicManagementSystem.Authentication.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/doctor")
@RestController
public class DoctorController {


    @Autowired
    private DoctorService doctorService;


   @PostMapping("/signin")
   public ResponseEntity<DoctorDto> doctorSignIn(@RequestBody DoctorDto doctorSignInRequest)
   {
       return ResponseEntity.ok(doctorService.DoctorSignIn(doctorSignInRequest));
   }


    @PostMapping("/signup")
    public ResponseEntity<DoctorDto> doctorSignUp(@RequestBody DoctorDto DoctorSignUpRequest)
    {

        return ResponseEntity.ok(doctorService.DoctorSignUp(DoctorSignUpRequest));

    }

}
