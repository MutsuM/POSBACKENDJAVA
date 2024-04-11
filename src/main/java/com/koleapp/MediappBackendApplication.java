package com.koleapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "KOLE API", version = "1.0", description = "Información del API de KOLE"))
public class MediappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediappBackendApplication.class, args);
		//System.setProperty("java.awt.headless", "true");
	}
	
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
}
