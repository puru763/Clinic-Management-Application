package com.ClinicManagementSystem.ClinicAdministrationMicroservice;





import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "admin")
public class AdministrationConfig {

    private String fixedNumber;
    private String fixedPassword;

    public String getFixedNumber() {
        return fixedNumber;
    }


    public String getFixedPassword() {
        return fixedPassword;
    }


}
