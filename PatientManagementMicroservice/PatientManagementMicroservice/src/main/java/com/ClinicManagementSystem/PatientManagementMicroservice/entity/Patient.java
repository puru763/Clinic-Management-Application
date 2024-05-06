package com.ClinicManagementSystem.PatientManagementMicroservice.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Builder
@Setter
@Getter
@RequiredArgsConstructor
@Data
public class Patient {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String phoneNumber;
        private String password;
        @OneToMany(mappedBy = "user")
        private List<Appointment> appointments;


}
