package com.example.api_productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "product")
public class Product {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Integer stock;

}
