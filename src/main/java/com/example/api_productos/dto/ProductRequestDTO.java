package com.example.api_productos.dto;

import org.hibernate.boot.SchemaAutoTooling;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para la creación o actualización de productos")
public class ProductRequestDTO {
	@Schema(
		description = "Nombre único del producto", 
		example = "CocaCola",
		requiredMode = Schema.RequiredMode.REQUIRED,
		minLength = 3,
		maxLength = 50)
	@NotBlank (message = "El nombre del producto no puede estar vacío")
	@Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
	private String name;
	
	@Schema (
		description = "Descripcion detallada del producto", 
		example = "Refresco de cola de 2L", 
		maxLength = 255)
	@Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
	private String description;
	
	@Schema (
		description = "Precio unitario del producto", 
		example = "10.99",
		requiredMode = Schema.RequiredMode.REQUIRED,
		minimum = "0.01"
		)
	@NotNull (message = "El precio es obligatorio")
	@DecimalMin(value = "0.01", message = "El precio de debe ser mayor a cero")
	@Min(value = 1)
	private Double price;
	
	@Schema (
		description = "Cantidad disponible en inventario", 
		example = "100",
		minimum = "0")
	@Min (value = 0, message = "El stock no puede ser negativo")
	private Integer stock = 0;
}
