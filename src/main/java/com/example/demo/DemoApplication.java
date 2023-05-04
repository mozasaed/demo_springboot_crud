package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =@Info(title = "Demo Swagger APIs"))
@SpringBootApplication
public class DemoApplication {
	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();
	}
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
