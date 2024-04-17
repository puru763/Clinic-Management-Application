package com.ClinicManagementSystem.DoctorManagementMicroservice.controller;

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


    @PostMapping("/signout")
    public ResponseEntity<DoctorDto> doctorSignUp(@RequestBody DoctorDto DoctorSignUpRequest)
    {

        return ResponseEntity.ok(doctorService.DoctorSignUp(DoctorSignUpRequest));

    }

}
