package com.ClinicManagementApplication.adminservice.config;

import com.ClinicManagementApplication.adminservice.AdminServiceApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminServiceApplication.class).properties("hibernate.dialect=org.hibernate.dialect.MySQLDialect");
    }
}
