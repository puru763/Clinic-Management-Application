package com.ClinicManagementSystem.PatientManagementMicroservice.service;

import com.ClinicManagementSystem.PatientManagementMicroservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
}