package com.example.api_productos.dto;

import org.hibernate.boot.SchemaAutoTooling;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para la respuesta de información de productos")
public class ProductResponseDTO {
	@Schema(
		description = "Id único generado por el sistema",
		example = "12345",
		requiredMode = Schema.RequiredMode.REQUIRED)
	@NotNull (message = "El id del producto es obigatorio")
	private Long id;
	
	@Schema(
		description = "Nombre único del producto",
		example = "CocaCola",
		requiredMode = Schema.RequiredMode.REQUIRED,
		minLength = 3,
		maxLength = 50)
	@NotBlank (message = "El nombre del producto no puede estar vacío")
	@Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
	private String name;
	
	@Schema(
			description = "Descripcion detallada del producto",
			example = "CocaCola",
			maxLength = 255)
		@Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
	private String description;
	
	@Schema(
		description = "Precio unitario del producto",
		example = "10.99", 
		requiredMode = Schema.RequiredMode.REQUIRED,
		minimum = "0.01")
	@NotNull (message = "El precio del producto es obligatorio")
	@DecimalMin(value = "0.01", message = "El precio del producto debe ser mayor a cero")
	private Double price;

	@Schema(
		description = "Cantidad disponible en inventario",
		example = "100",
		minimum = "0"
	)
	@NotNull(message = "El stock no puede ser nulo")
	@Min (value = 0, message = "El stock no puede ser negativo")
	private Integer stock;
}
