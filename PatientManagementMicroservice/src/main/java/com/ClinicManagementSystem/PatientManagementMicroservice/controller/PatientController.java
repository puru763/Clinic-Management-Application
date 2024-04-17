package com.ClinicManagementSystem.PatientManagementMicroservice.controller;

@RequestMapping("api/v1/patient")
@RestController
public class PatientController {


    @Autowired
    private PatientService patientService;


    @PostMapping("/signin")
    public ResponseEntity<PatientDto> patientSignIn(@RequestBody PatientDto patientSignInRequest)
    {
        return ResponseEntity.ok(patientService.PatientSignIn(patientSignInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<PatientDto> patientSignUp(@RequestBody PatientDto patientSignUnRequest)
    {

        return ResponseEntity.ok(patientService.PatientSignUp(patientSignUnRequest));

    }
}
