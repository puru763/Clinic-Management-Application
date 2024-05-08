package com.clinickmanagementapplication.administrator.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/administrator")
public class AdministratorController {


//    @PostMapping("/register-patient")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<?>registerPatient(@RequestBody Patient patient){
//        try{
//            Patient registerPatient = patientService.registerPatient(patient);
//            if(registerPatient != null)
//            {
//                return  ResponseEntity.status(HttpStatus.CREATED).body(registerPatient);
//            }else{
//                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Patient with Mobile Number  " + patient.getMobileNumber());
//            }
//        }
//        catch (Exception e)
//        {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Error Occured During Patient Register");
//        }
//    }



}
