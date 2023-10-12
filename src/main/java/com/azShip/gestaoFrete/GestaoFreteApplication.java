package com.azShip.gestaoFrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "DESAFIO BACKEND AZSHIP", version = "1", description = "Projeto de gestão de fretes desenvolvido para o desafio BackEnd AZSHIP"))
public class GestaoFreteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoFreteApplication.class, args);
	}

}
