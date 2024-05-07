package com.clinickmanagement.patient.controller;

import com.clinickmanagement.patient.entity.Patient;
import com.clinickmanagement.patient.service.PatientService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping("/register-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>registerPatient(@RequestBody Patient patient){
        try{
            Patient registerPatient = patientService.registerPatient(patient);
            if(registerPatient != Null)
            {
                return  ResponseEntity.status(HttpStatus.CREATED).body(registerPatient);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Patient with Mobile Number  " + patient.getMobileNumber())
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Error Occured During Patient Register");
        }
    }
}


