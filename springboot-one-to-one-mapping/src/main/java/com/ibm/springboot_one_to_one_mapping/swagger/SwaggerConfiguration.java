package com.ibm.springboot_one_to_one_mapping.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Your API Title").version("1.0.0").description("Your API Description"));
    }
}

