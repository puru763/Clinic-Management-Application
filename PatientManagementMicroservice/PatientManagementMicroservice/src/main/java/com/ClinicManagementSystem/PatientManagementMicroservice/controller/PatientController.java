package com.ClinicManagementSystem.PatientManagementMicroservice.controller;


import com.ClinicManagementSystem.PatientManagementMicroservice.dto.UserDTO;
import com.ClinicManagementSystem.PatientManagementMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {



//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public  void createProduct(@RequestBody ProductRequest productRequest){
//        productService.createProduct(productRequest);
//    }

}