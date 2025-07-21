package com.example.api_productos.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.api_productos.config.BaseIntegrationTest;
import com.example.api_productos.model.Product;

@DisplayName("Integration tests for ProductRepository")
public class ProductRepositoryIntegrationTest extends BaseIntegrationTest{

	@Autowired
	private ProductRepository productRepository;

	@DisplayName("Test to save a product")
	@ParameterizedTest
	@ValueSource (strings = {"Lapicero", "Cuaderno", "Borrador"})
	void testSaveProduct(String name) {
		Product saved = productRepository.save(new Product(null, name, "Marca Bic", 5D, 100));
		assertEquals(name, saved.getName());
	}
}
