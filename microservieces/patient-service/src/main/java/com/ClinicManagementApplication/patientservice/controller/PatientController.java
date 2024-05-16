package com.ClinicManagementApplication.patientservice.controller;

import com.ClinicManagementApplication.patientservice.dto.PatientDTO;
import com.ClinicManagementApplication.patientservice.entity.Patient;
import com.ClinicManagementApplication.patientservice.service.AppointmentService;
import com.ClinicManagementApplication.patientservice.service.PatientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);



    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;





    @PostMapping("/register-patient")
    @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<?> registerPatient(@RequestBody Patient patient)
    {
        try{
                Patient registerPatient=  patientService.registerPatient(patient);
                if(registerPatient != null) {
                    return ResponseEntity.status(HttpStatus.CREATED).body(registerPatient);
                }
                else {
                    return  ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Patient With This Mobile NUmber Is Already Exist");
                }
        }
        catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error  Occur  During Patient Regestration");
        }
    }





    @GetMapping("/get-all-patients")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        try{
            List<PatientDTO> patients= patientService.getAllPatients();
            return ResponseEntity.ok(patients);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/get-patient-by-id/{patientId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<?> getPatientById (@RequestParam Long patientId){
        try{
            PatientDTO getPatient = patientService.getPatientByPatientId(patientId);
            if(getPatient != null) {
                return ResponseEntity.ok(getPatient);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }





}







