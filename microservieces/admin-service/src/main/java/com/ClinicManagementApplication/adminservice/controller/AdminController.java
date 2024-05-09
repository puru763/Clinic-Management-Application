package com.ClinicManagementApplication.adminservice.controller;

import com.ClinicManagementApplication.patientservice.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@RestController
public class AdminController {

    private final WebClient webClient;

    @Autowired
    public AdminController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://patient-service-url").build();
    }

    @GetMapping("/get-all-patients")
    public Mono<ResponseEntity<List<Patient>>> getAllPatientsFromPatientService() {
        return webClient.get()
                .uri("/get-all-patients")
                .retrieve()
                .bodyToFlux(Patient.class)
                .collectList()
                .map(patients -> ResponseEntity.ok().body(patients))
                .onErrorResume(WebClientResponseException.class, ex -> handleWebClientResponseException(ex));
    }

    private Mono<ResponseEntity<List<Patient>>> handleWebClientResponseException(WebClientResponseException ex) {
        HttpStatus errorStatus = (HttpStatus) ex.getStatusCode();
        if (errorStatus.is4xxClientError()) {
            return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList()));
        } else if (errorStatus.is5xxServerError()) {
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList()));
        }
        return Mono.error(ex);
    }
}
