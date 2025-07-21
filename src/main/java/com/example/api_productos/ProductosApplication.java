package com.example.api_productos;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API de Productos",
				version = "1.0.0",
				description = "API para gestión de productos en el inventario",
				contact = @Contact(
						name = "Equipo de Desarrollo",
						email = "dev@empresa.com",
						url = "https://empresa.com/soporte"
						),
				license = @License(
						name = "Licencia MIT",
						url = "https://opensource.org/licenses/MIT"
						)
				)
		)
public class ProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
