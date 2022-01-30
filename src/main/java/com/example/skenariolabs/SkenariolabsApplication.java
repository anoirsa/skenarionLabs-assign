package com.example.skenariolabs;

import com.example.skenariolabs.service.ExternalApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SkenariolabsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SkenariolabsApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ExternalApiService externalApiService) {
		return args -> {
			externalApiService.firstApiCall();
		};
	}

}
