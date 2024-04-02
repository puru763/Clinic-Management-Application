package com.ClinicManagementSystem.Authentication.controller;

import com.ClinicManagementSystem.Authentication.dto.UserDto;
import com.ClinicManagementSystem.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
public class UserController {


    @Autowired
    private  UserService userService;



    @PostMapping("/signin")
    public ResponseEntity<UserDto> signIn(@RequestBody UserDto signInRequest){
        // Call signin method on userService instance
        UserDto result = userService.signin(signInRequest);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto signUpRequest){
        // Call signup method on userService instance
        UserDto result = userService.signup(signUpRequest);
        return ResponseEntity.ok(result);
    }
}
