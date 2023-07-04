package com.lifehub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Life Hub", description = "API do projeto Life Hub, Sistema de gerenciamento pessoal, seja para o meio financeiro ou pessoal."))
@SpringBootApplication
public class LifehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifehubApplication.class, args);
	}

}
