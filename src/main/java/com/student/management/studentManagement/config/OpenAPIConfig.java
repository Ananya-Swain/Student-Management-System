package com.student.management.studentManagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Student Course Management API",
                version = "1.0",
                description = "APIs to manage Student, Course and their Enrollment"
        )
)

public class OpenAPIConfig {
}
