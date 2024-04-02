package com.ClinicManagementSystem.Authentication.service;

import com.ClinicManagementSystem.Authentication.dto.UserDto;

public interface UserService {

      UserDto signup(UserDto signUpRequest);

     UserDto signin(UserDto signUpRequest) ;

}
